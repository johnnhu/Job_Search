DATA_PATH=./data
DATABASE_NAME=postgres
LOG_PATH=logfile
SCRIPT_PATH=./src/main/java/jSearch/scripts

db_init:
	mkdir -p $(DATA_PATH)
	initdb -D $(DATA_PATH)

db_user:
	createuser postgres -s

db_start:
	pg_ctl start -D $(DATA_PATH) -l $(LOG_PATH)

db_list:
	psql -l

db_bootstrap:
	psql -U postgres -d $(DATABASE_NAME) -a -f $(SCRIPT_PATH)/setup.sql

db_stop:
	pg_ctl stop -D $(DATA_PATH) -l $(LOG_PATH)
