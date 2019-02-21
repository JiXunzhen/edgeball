mysql:
	mysql -ueleme --password="eleme" -e "CREATE DATABASE if not exists edgeball"
	mysql -ueleme --password="eleme" < src/main/resources/database/edgeball.sql
