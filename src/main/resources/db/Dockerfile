FROM liquibase/liquibase
COPY changelog/*.yaml /liquibase/changelog/
COPY changelog/sql/*.sql /liquibase/changelog/sql/
COPY --chown=liquibase:liquibase genLiquibaseProps.sh /liquibase/