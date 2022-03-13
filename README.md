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
   1. First, run `make db_init` to create the database cluster
   2. Second, run `make db_user` to create a superuser named "postgres"
   3. Then, run `make db_start` to begin the database in the background on `localhost`
   4. (Aside: there also exists `make db_stop` should you ever need to take the DB down!)
5. Run `setup.sql` (using IntelliJ, or via the command-line) to initialize the database
6. Run the app via `App.java`

### Troubleshooting

Troubleshooting steps.

#### PostgreSQL driver is unavailable; `Class.forName("org.postgresql.Driver");` throws an exception

While you should be able to just run `mvn clean install`, this happened to me a few times. To fix it, I added the dependency through IntelliJ's interface.

1. File > Project Structure
2. Libraries
3. Click the top "+" button
4. Select "From Maven..."
5. Search for "PostgreSQL"
6. Select postgresql:9.2-1002.jdbc4, i.e., the latest version

## Usage

TODO: list app features.

## TODOs

TODO: create tasks.

## Contributing

TODO: write contributing steps.
