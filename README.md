# Spring Boot Upgrade Example

Simple example of upgrading Spring Boot 2 to Spring Boot 3. Refer to the commit history for the upgrade steps.

### Other Useful Examples

Phil Webb has a talk on the upgrade process with a sample repo.

[![Mind the Gap: Jumping from Spring Boot 2.x to 3.x](https://img.youtube.com/vi/HrRQExD3xow/0.jpg)](https://www.youtube.com/watch?v=HrRQExD3xow)

[Sample Repo](https://github.com/philwebb/upgrading-to-spring-boot-3)

## Branches

* `example-upgrade` - example of the upgrade with simplified commits, branch may be rewritten in the future, so I
  recommend pulling with `git pull -r`.
* `main` - Spring Boot 2.7 example project.
* `upgrade` - Commits to upgrade from Spring Boot 2 to 3.

## Components

The application uses Spring Data with and H2 in-memory datastore for data retrieval and Spring Security for
authentication and authorization. 