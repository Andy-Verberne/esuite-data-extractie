---
name: check-platform-versions
description: Check the platforms listed in versions.md (Java, Quarkus, Kotlin, Gradle, PostgreSQL, base images, etc.) for newer stable releases and security patches, and record the results in versions.md. Use when asked to check for platform updates, security patches, or to refresh versions.md.
---

# Check platform versions

`versions.md` at the repo root lists the platform-level components of this project
(not individual libraries; those follow the Quarkus BOM). Each component is one YAML
block. This skill refreshes that file: it confirms what the repo uses, finds the
latest stable releases, and records both.

This skill only updates `versions.md`. It does not upgrade the project itself unless
the user asks for that separately.

## Steps

### 1. Read the current state

Read `versions.md` and parse every YAML block under `## Components`. For each one, note
`name`, `pinned_in`, `current`, `latest_stable`, `latest_same_line` (if any),
`check` and `status`.

### 2. Confirm what the repo uses now

For each component, open every file in `pinned_in` and read the actual value.
If it differs from `current`, set `current` to what the repo says. The repo is the
source of truth, not the document.

Where to look:

| Component | File | What to read |
|---|---|---|
| Java | `build.gradle.kts` | `JavaVersion.VERSION_xx`, `JvmTarget.JVM_xx` |
| Quarkus | `gradle.properties` | `quarkusPlatformVersion`, `quarkusPluginVersion` |
| Kotlin | `build.gradle.kts` | `kotlin("jvm") version "..."` |
| Gradle | `gradle/wrapper/gradle-wrapper.properties` | `distributionUrl` |
| Container images | `src/main/docker/Dockerfile.*` | `FROM` lines |
| PostgreSQL | `src/main/resources/application.properties` | `quarkus.datasource.db-kind` (no server version is pinned) |
| Helm deps | `helm/Chart.yaml` | `dependencies[].version` |

### 3. Look for platforms that are missing

Scan the repo for platform-level pins that have no block yet, and add a block for
each one in the same format. Check at least:

- every `FROM` line in `src/main/docker/` and any other `Dockerfile*`
- CI config (`.github/workflows/`, `.gitlab-ci.yml`, `Jenkinsfile`): runner images, `setup-java` versions, etc.
- `helm/Chart.yaml` dependencies
- new Gradle plugins in `build.gradle.kts` / `settings.gradle.kts` that are platform-level
  (a framework or toolchain, not a library)

If something listed under `## Not present` now exists, move it into a component block.
If a component was removed from the repo, delete its block.

### 4. Find the latest stable releases

For each component, find the newest **stable GA** release. Ignore Alpha, Beta, M (milestone),
CR, RC, EA, SNAPSHOT and nightly builds. Use the URLs in the block's `check` field.
Machine-readable sources work best:

```bash
# Quarkus (stable only, highest first)
curl -sS https://repo1.maven.org/maven2/io/quarkus/platform/quarkus-bom/maven-metadata.xml \
  | grep -o '<version>[^<]*' | sed 's/<version>//' \
  | grep -v -E 'Alpha|Beta|CR|RC|SNAPSHOT' | sort -V | tail -5

# Kotlin
curl -sS https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-stdlib/maven-metadata.xml \
  | grep -o '<version>[^<]*' | sed 's/<version>//' | grep -E '^[0-9.]+$' | sort -V | tail -5

# Gradle: latest overall, and latest on the current major line (example: 8.x)
curl -sS https://services.gradle.org/versions/current | grep '"version"'
curl -sS https://services.gradle.org/versions/all \
  | grep -o '"version" : "8\.[0-9.]*"' | head -1
```

For sources without a simple API, use web search or fetch the page:

- **Quarkus LTS lines:** https://quarkus.io/releases. Note which lines are LTS and which are
  still maintained.
- **Java:** the Oracle `21u` / `25u` release notes pages give the latest update per LTS.
  Critical Patch Updates (CPUs) ship quarterly in January, April, July and October.
- **PostgreSQL:** https://www.postgresql.org/support/versioning/ and the PostgreSQL
  news archive. Minor releases are quarterly (Feb/May/Aug/Nov).
- **Red Hat UBI images:** the catalog.redhat.com page in the `check` field shows the
  tag marked `latest`.
- **quay.io images:** quay.io may block automated reads. If you can't verify, keep the
  value and say so in `notes`.

Record two things where they differ:
- `latest_same_line`: the newest patch on the major/minor line the repo is on (the
  security-fix-only path).
- `latest_stable`: the newest stable release overall (for frameworks with LTS lines,
  say which is LTS).

If a lookup fails, keep the previous value. Add a line to `notes` that it couldn't be
verified on this date. Never guess a version.

### 5. Set the status

Compare `current` with the latest versions:

| status | meaning |
|---|---|
| `up-to-date` | current equals latest_stable |
| `patch-behind` | only the patch version differs (likely security/bug fixes, apply soon) |
| `minor-behind` | the minor version differs |
| `major-behind` | the major version differs |
| `unpinned` | the repo doesn't pin a version (e.g. PostgreSQL server, native builder) |

Also flag in `notes` when the line the repo is on is **end of life or no longer
maintained** (for example a non-LTS Quarkus line, or a PostgreSQL major past its EOL date).
That matters more for security than the size of the version gap.

### 6. Write versions.md

- Edit the blocks in place. Keep the field names and order unchanged so diffs stay small
  and other agents can parse the file.
- Update `Last checked: YYYY-MM-DD` to today's date.
- Keep the YAML valid: quote version strings (`"3.40.1.1"`) so that values like `9.8`
  are not read as numbers.

### 7. Report

Summarise for the user:
- components where `status` changed or a new release appeared since the last check
- anything on an end-of-life or unmaintained line
- lookups you couldn't verify

If you're working in a branch, commit `versions.md` with a message like
`Update versions.md (checked YYYY-MM-DD)` and open a PR when the user asks for one.
