init_db:
	mkdir -p ./data
	initdb -D ./data

run_db:
	pg_ctl start -D ./data -l logfile
