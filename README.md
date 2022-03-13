# jSearch

An application to help prospective interns track job applications. Envisioned as an alternative to existing software solutions like the UBC Science Co-op website.

Built for CPSC 304.

## Setup

Instructions for local development.

### Prerequisites

* Git; `git --version` >= 2.25.1
* Java 8; an Amazon Corretto build is preferred
  * To manage Java versions, I recommend [SDKMAN](https://sdkman.io/)
* PostgreSQL; `psql --version` >= 14.2
  * To install, I recommend using [Homebrew](https://brew.sh/) via `brew install postgresql`
* Docker; `docker --version` >= 20.10.12
  * To install, I again recommend Homebrew; use `brew install docker`
  * It's likely helpful to have Docker desktop
* make; `make --version` >= 4.2.1
  * Should already be installed, but if not, use `brew` once again

The following tools are optional, but helpful.

* curl
  * A command-line tool for testing our REST API; should be installed by default
* Postman
  * A GUI for testing our REST API, available [here](https://postman.com/)

### Installation

1. Clone the repository, available at [this link](https://github.com/emilyychenn/jSearch)
   1. (In particular, you should clone it via SSH or the `gh` CLI tool!)
2. Open the project using IntelliJ; this should auto-magically pick up on dependencies
3. Run the test suite (under `/test`); ensure all tests are passing
4. Begin the database
   1. First, run `make init_db` to create the database cluster
   2. Then, run `make run_db` to begin the database in the background on `localhost`
5. Run `setup.sql` (using IntelliJ, or via the command-line) to initialize the database
6. Run the app via `App.java`

## Usage

TODO: list app features.

## TODOs

TODO: create tasks.

## Contributing

TODO: write contributing steps.
