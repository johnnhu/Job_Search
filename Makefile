db_init:
	mkdir -p ./data
	initdb -D ./data

db_user:
	createuser postgres -s

db_start:
	pg_ctl start -D ./data -l logfile

db_stop:
	pg_ctl stop -D ./data -l logfile
