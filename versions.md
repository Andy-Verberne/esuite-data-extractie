# Platform versions

Platform-level components this project depends on, tracked for security patches and upgrades.
Individual libraries are out of scope: they follow the Quarkus BOM (`enforcedPlatform` in `build.gradle.kts`).

Last checked: 2026-10-30

## How to use this file

- Each component is one YAML block below. Fields:
  - `pinned_in`: file(s) and key where the repo sets the version. Update all of them together.
  - `current`: version the repo uses today.
  - `latest_stable`: newest GA release on the line we can move to, as of `Last checked`.
  - `latest_same_line`: newest patch on the line we're on (security fixes without a major/minor jump), when different from `latest_stable`.
  - `check`: where to look up new releases (machine-readable source first).
  - `status`: `up-to-date`, `patch-behind`, `minor-behind`, `major-behind`, or `unpinned`.
- When updating: refresh `latest_*`, `status` and `Last checked`. When bumping the repo, also update `current`.

## Components

```yaml
- name: Java (JDK / runtime)
  pinned_in:
    - build.gradle.kts: java.sourceCompatibility / targetCompatibility = JavaVersion.VERSION_21
    - build.gradle.kts: kotlin.compilerOptions.jvmTarget = JVM_21
    - src/main/docker/Dockerfile.jvm and Dockerfile.legacy-jar: base image openjdk-21
  current: "21 (LTS)"
  latest_same_line: "21.0.13 (2026-10 CPU)"
  latest_stable: "25.0.5 (latest LTS); 27 is the newest non-LTS feature release"
  check:
    - https://www.oracle.com/java/technologies/javase/21u-relnotes.html
    - https://www.oracle.com/java/technologies/javase/25u-relnotes.html
    - https://openjdk.org/groups/vulnerability/advisories/
  notes: Patch level comes from the container base image, not from the repo. CPUs ship quarterly (Jan/Apr/Jul/Oct).
  status: major-behind  # 21 is still supported LTS; 25 is the newer LTS

- name: Quarkus (platform BOM + Gradle plugin)
  pinned_in:
    - gradle.properties: quarkusPlatformVersion
    - gradle.properties: quarkusPluginVersion
  current: "3.34.6"
  latest_stable: "3.40.1.1 (LTS, released 2026-10-19)"
  other_supported_lines: "3.33.4.1 (LTS, maintained until 2027-03-25)"
  check:
    - https://repo1.maven.org/maven2/io/quarkus/platform/quarkus-bom/maven-metadata.xml
    - https://quarkus.io/releases
    - https://github.com/quarkusio/quarkus/releases
  notes: 3.34 is a non-LTS line and no longer receives fixes. Move to 3.40 LTS. 4.0 is in beta (4.0.0.Beta2), not stable.
  status: minor-behind

- name: Kotlin (compiler + Gradle plugins jvm, allopen)
  pinned_in:
    - build.gradle.kts: plugins { kotlin("jvm") version, kotlin("plugin.allopen") version }
  current: "2.3.20"
  latest_stable: "2.4.21"
  check:
    - https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-stdlib/maven-metadata.xml
    - https://github.com/JetBrains/kotlin/releases
  notes: Check the Quarkus release notes for the Kotlin version it supports before bumping.
  status: minor-behind

- name: Gradle (wrapper)
  pinned_in:
    - gradle/wrapper/gradle-wrapper.properties: distributionUrl
  current: "8.14.4"
  latest_same_line: "8.14.6"
  latest_stable: "9.8.2"
  check:
    - https://services.gradle.org/versions/current
    - https://gradle.org/releases/
  notes: Upgrade with ./gradlew wrapper --gradle-version <v> so gradle-wrapper.jar and gradlew scripts are refreshed too.
  status: major-behind

- name: PostgreSQL (database server)
  pinned_in:
    - src/main/resources/application.properties: quarkus.datasource.db-kind=postgresql (no server version pinned)
  current: "unknown (set by the deployment environment)"
  latest_stable: "18.6 (released 2026-08-13)"
  other_supported_lines: "17.11, 16.15, 15.19, 14.24 (14 is EOL on 2026-11-12); 19 is at RC1"
  check:
    - https://www.postgresql.org/support/versioning/
    - https://www.postgresql.org/about/newsarchive/
  notes: JDBC driver version comes from the Quarkus BOM. Next quarterly minor release expected mid November 2026.
  status: unpinned

- name: JVM container base image
  pinned_in:
    - src/main/docker/Dockerfile.jvm: FROM registry.access.redhat.com/ubi9/openjdk-21
    - src/main/docker/Dockerfile.legacy-jar: FROM registry.access.redhat.com/ubi9/openjdk-21
  current: "ubi9/openjdk-21:1.21"
  latest_stable: "ubi9/openjdk-21:1.24"
  check:
    - https://catalog.redhat.com/software/containers/ubi9/openjdk-21/6501cdb5c34ae048c44f7814
    - https://github.com/jboss-container-images/openjdk
  notes: Image tag determines the JDK patch level and OS packages. A ubi10 variant also exists. The smaller ubi9/openjdk-21-runtime image (also 1.24) is an option for runtime-only use.
  status: minor-behind

- name: Native container base image (minimal)
  pinned_in:
    - src/main/docker/Dockerfile.native: FROM registry.access.redhat.com/ubi9/ubi-minimal
  current: "ubi9/ubi-minimal:9.5"
  latest_stable: "ubi9/ubi-minimal:9.8"
  check:
    - https://catalog.redhat.com/en/software/containers/ubi9/ubi-minimal/615bd9b4075b022acc111bf5
  status: minor-behind

- name: Native container base image (micro)
  pinned_in:
    - src/main/docker/Dockerfile.native-micro: FROM quay.io/quarkus/ubi9-quarkus-micro-image
  current: "2.0"
  latest_stable: "2.0 (floating tag, rebuilt by the Quarkus team)"
  check:
    - https://quay.io/repository/quarkus/ubi9-quarkus-micro-image?tab=tags
  notes: Not verified online (quay.io blocks automated reads). Re-pull the image to pick up patches.
  status: up-to-date

- name: Native image builder (Mandrel / GraalVM)
  pinned_in:
    - none (Quarkus picks the default builder image for the Quarkus version; override with quarkus.native.builder-image)
  current: "Quarkus 3.34 default (JDK 21 Mandrel)"
  latest_stable: "Mandrel 25.0.4.1 (JDK 25) / 23.1.12.1 (JDK 21)"
  check:
    - https://github.com/graalvm/mandrel/releases
  notes: Only relevant when building native images.
  status: unpinned

- name: Helm chart dependency (bitnami/common)
  pinned_in:
    - helm/Chart.yaml: dependencies[common].version = "2.x.x"
  current: "2.x.x (range, resolves to latest 2.x)"
  latest_stable: "2.41.0 (2026-06-29)"
  check:
    - https://artifacthub.io/packages/helm/bitnami/common
  notes: Bitnami moved most of its catalog to a paid/legacy model in 2025. Confirm the charts.bitnami.com repository still serves this chart.
  status: up-to-date
```

## Not present

- CI: no CI configuration (no `.github/workflows`, GitLab CI or Jenkinsfile) is in the repo, so there are no runner images to track.
