<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![License: GPL v3][license-shield]][license-url]
<!-- [![Javadoc][javadoc-shield]][javadoc-url] -->
<!-- [![MavenCentral][maven-shield]][maven-url] -->




<!-- PROJECT LOGO -->
<br />
<div align="center">
  <!-- a href="https://github.com/mlgr-io/kotlin-skeleton">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a //-->

<h3 align="center">Kotlin project skeleton</h3>

  <p align="center">
    Kotlin project blueprint, including common dependencies. 
    <!-- br />
    <a href="https://github.com/mlgr-io/kotlin-skeleton"><strong>Explore the docs »</strong></a //-->
    <br />
    <br />
    <!-- a href="https://github.com/mlgr-io/kotlin-skeleton">View Demo</a>
    · //-->
    <a href="https://github.com/mlgr-io/kotlin-skeleton/issues">Report Bug</a>
    ·
    <a href="https://github.com/mlgr-io/kotlin-skeleton/issues">Request Feature</a>
    ·
    <a href="CHANGELOG.md">Changelog</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project was meant to help us get new project initialized faster; it should be understand as a blueprint for all
kind of projects written in Kotlin.

You may abstract the list of included plugins and dependencies from the [io.mailguru.gradle-config plugin page](https://github.com/mlgr-io/gradle-config).

### Versioning strategy

This library uses [Semantic Versioning 2.0](https://semver.org) and generates its Changelog from
[Conventional Commit](https://www.conventionalcommits.org/en/v1.0.0/) messages.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

We choose to support the lowest actively supported Java version at the time of writing, that is, Java 11 (this may be
subject to change in future major releases).

### Installation

Since this project isn't going to be released at maven central (because that wouldn't make any sense), you may clone
the latest `develop` branch of this repository, do some cleanup, and start your work from a clean local git repo: 
```sh
git clone https://github.com/mlgr-io/kotlin-skeleton.git your-desired-project-folder

cd your-desired-project-folder

git remote rm origin

# Optional steps to prepare your local copy of the repository for your own project:

# Remove all tags
git tag | xargs git tag -d

# Squash the whole history into a single commit
git reset $(git commit-tree HEAD^{tree} -m "feat: initial commit")
```

You may also want to replace your copy of `CHANGELOG.md` by a
[clean stub](https://github.com/mlgr-io/gradle-config/blob/b21597a6dc828f5aedfdd26d68fd9932971a12f1/CHANGELOG.md) (the
"draft new release" GitHub action expects at least such a stub and will throw an error if the file is missing or not
well-formatted).

### (Semi-)Automatic Releases, Changelog generation and maven publication

This project includes GitHub actions that create releases, update the docs and publish your artifacts to a maven
registry. For publishing, please see the following section. For information on how creating releases works, please see
the official documentation of the [GitFlow release workflow using GitHub actions](https://github.com/thomaseizinger/github-action-gitflow-release-workflow).

### Publishing signed artifacts to an arbitrary maven registry

If you want your code to be packed, signed and published (and closed and released) to maven central on a release, you'll
have to deposit the required secrets at your GitHub repository. The following secrets are required for that GitHub
action to work (we assume that you're familiar with GPG and already have generated a key pair; if not, please have a 
look at the [Central Repository GPG guide](https://central.sonatype.org/publish/requirements/gpg/)):

* `GPG_KEY_ID` The short (8 chars) key ID of your GPG key; on macOS, you may retrieve the key ID by executing
  ```shell
  gpg --list-secret-keys --keyid-format short | grep sec | cut -d' ' -f 4 | cut -d'/' -f 2`
  ```
* `GPG_SIGNING_KEY` The GPG signing key, encoded as Base64. You will most likely get this information by executing
  ```shell
  cat ~/.gnupg/secring.gpg | base64
  ```
* `GPG_PASSPHRASE` The passphrase for your preceding GPG key, as chosen on key pair generation.
* `MAVEN_CENTRAL_USERNAME` The username for your publication target maven registry. \
  The [example build.gradle.kts](build.gradle.kts#L19) is configured to publish to `https://s01.oss.sonatype.org`. 
* `MAVEN_CENTRAL_PASSWORD` The password for the maven registry, related to `MAVEN_CENTRAL_USERNAME`.

To make sure everything works as expected, we **strongly recommend** to disable the `closeAndReleaseRepository` task on 
your first publication(s):

To **remove the auto-close-and-release behaviour**, please remove (or comment) the `closeAndReleaseRepository` gradle
task from `release-publish.yml` (nearly at the end). After disabling, you have to close and release your artifact
manually from your staging repository at the sonatype registry (only if you published to their registry, of course).

If you want to **remove auto-publishing completely** (that is, no maven publish on a finished release), please delete the
`publish` job from the [release-publish.yml](.github/workflows/release-publish.yml#L59) (starting from L59) action
configuration.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also
simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/YourAmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/YourAmazingFeature`)
5. Open a Pull Request

There is also an [excellent step-by-step guide](https://gist.github.com/james-priest/74188772ef2a6f8d7132d0b9dc065f9c)
written by [James Priest](https://james-priest.github.io).


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the **GNU General Public License v3.0**. See [LICENSE.md](LICENSE.md) for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Project Link: [https://github.com/mlgr-io/kotlin-skeleton](https://github.com/mlgr-io/kotlin-skeleton)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
<!-- [javadoc-url]: https://javadoc.io/doc/io.mailguru/api-core -->
<!-- [javadoc-shield]: https://javadoc.io/badge2/io.mailguru/api-core/javadoc.svg?style=for-the-badge&color=yellow -->
<!-- [maven-url]: https://search.maven.org/artifact/io.mailguru/api-core -->
<!-- [maven-shield]: https://img.shields.io/maven-central/v/io.mailguru/api-core?style=for-the-badge -->
[contributors-shield]: https://img.shields.io/github/contributors/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[contributors-url]: https://github.com/mlgr-io/kotlin-skeleton/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[forks-url]: https://github.com/mlgr-io/kotlin-skeleton/network/members
[stars-shield]: https://img.shields.io/github/stars/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[stars-url]: https://github.com/mlgr-io/kotlin-skeleton/stargazers
[issues-shield]: https://img.shields.io/github/issues/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[issues-url]: https://github.com/mlgr-io/kotlin-skeleton/issues
[license-shield]: https://img.shields.io/github/license/mlgr-io/kotlin-skeleton.svg?style=for-the-badge
[license-url]: https://github.com/mlgr-io/kotlin-skeleton/blob/master/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com
