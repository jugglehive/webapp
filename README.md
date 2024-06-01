# Juggle Hive Web Application

## Overview

This repository contains the source code for Juggle Hive's Website. It is structured into three main components: the frontend, backend, and database. This setup showcases the work of the developers for transparency and portfolio purposes, and may be used in the future to support hosting private servers for the game backend.

## Index

1. [Components](#components)
    - [Frontend](#frontend)
      - [File Structure](#file-structure)
      - [Source Directory](#source-directory)
        - [App Module](#app-module)
        - [Components](#components-1)
        - [Assets](#assets)
    - [Backend](#backend)
      - [File Structure](#file-structure-1)
      - [Source Directory](#source-directory-1)
    - [Database](#database)
      - [TTRPG Schema](#ttrpg-schema)
2. [License](#license)
3. [Developers](#developers)

## Components

### Frontend

The frontend is built using Angular and is responsible for the user interface. It includes various components such as the hero section, home section with sub-components (projects and whatsup), navbar, and footer. The configuration files for TypeScript, Angular, and TailwindCSS are also present.

- **Framework**: Angular
- **Styling**: TailwindCSS
- **Build Tool**: Angular CLI

#### File Structure

- **.editorconfig**: Configuration for editor settings to ensure consistent coding styles.
- **angular.json**: Angular CLI configuration file for defining project structure and build options.
- **package.json**: Manages project dependencies and scripts.
- **tsconfig.json**: TypeScript configuration file for the entire project.
- **tailwind.config.js**: TailwindCSS configuration file for customizing the utility-first CSS framework.

#### Source Directory

- **src/index.html**: The main HTML file of the application.
- **src/main.ts**: The main entry point for the Angular application.
- **src/styles.css**: Global styles for the application.

##### App Module

- **src/app/app.module.ts**: Defines the root module of the application.
- **src/app/app-routing.module.ts**: Manages routing for different components.
- **src/app/app.component.***: The main component of the application.

##### Components

- **src/app/hero**: Contains the hero section of the website.
    - **hero.component.***: Files for the hero section.
- **src/app/home**: Contains the home section, which includes sub-components.
    - **home.component.***: Files for the home section.
    - **projects/projects.component.***: Files for the projects sub-section.
    - **whatsup/whatsup.component.***: Files for the what's up sub-section.
- **src/app/navbar**: Contains the navigation bar.
    - **navbar.component.***: Files for the navigation bar.
- **src/app/footer**: Contains the footer section.
    - **footer.component.***: Files for the footer section.

##### Assets

- **src/assets**: Directory for static assets such as images and logos.

### Backend

The backend is developed in Java using the Spring Boot framework. It provides RESTful APIs for managing TTRPG data, including characters, items, skills, and more. The backend includes controllers, services, repositories, and model entities.

- **Framework**: Spring Boot
- **Build Tool**: Maven
- **Containerization**: Docker

#### File Structure

- **Dockerfile**: Configuration file for Docker to containerize the application.
- **mvnw, mvnw.cmd**: Maven wrapper scripts for ensuring a consistent build environment.
- **pom.xml**: Maven configuration file that manages dependencies and build configuration.

#### Source Directory

- **src/main/java/com/jugglehive/backend**: Main package for the backend application.
    - **BackendApplication.java**: Main class for running the Spring Boot application.
    - **WebRoutingConfig.java**: Configuration class for web routing.
    - **controller/CharaController.java**: REST controller for character-related endpoints.
    - **exception**: Contains custom exception handling classes.
        - **customExceptions/NoCharactersFoundException.java**: Custom exception for no characters found.
        - **handlers/CustomExceptionHandler.java**: Handles custom exceptions.
        - **handlers/DefaultExceptionsHandler.java**: Handles default exceptions.
    - **model**: Contains the data model for the application.
        - **dto**: Data Transfer Objects for transferring data.
            - **GetCharaByUserIdDTO.java**: DTO for getting character by user ID.
            - **GetCharaFullDTO.java**: DTO for full character details.
            - **GetCharaLightDTO.java**: DTO for light character details.
        - **entity**: Entity classes representing database tables.
            - **login/User.java**: Entity for user login details.
            - **ttrpg**: Entities for TTRPG elements.
                - **AllowedItem.java, BaseStats.java, Chara.java, CharacterClasses.java, CharacterInfo.java, CharactersTreePoints.java, ClassEntity.java, Inventory.java, Item.java, Race.java, RaceSkill.java, Region.java, Skill.java, SkillFamily.java, SkillModifier.java, SkillModifierDices.java, TreeEntity.java, TreeSkills.java**: Various entities representing TTRPG elements.
        - **enums**: Enums for different types used in the application.
            - **CostType.java, ItemType.java, SkillType.java, StatScaling.java, StatTarget.java, StatType.java, TargetType.java**: Various enums for categorizing data.
    - **repository/CharaRepository.java**: Repository interface for character-related database operations.
    - **service**: Contains service classes that implement business logic.
        - **CharaService.java, CharaServiceImpl.java**: Services for character-related operations.
- **src/main/resources/application.properties**: Configuration file for Spring Boot application.
- **src/test/java/com/jugglehive/backend/BackendApplicationTests.java**: Unit tests for the backend application.

### Database

The project supports both MySQL and PostgreSQL databases, with SQL scripts provided for setting up the necessary schema and tables.

- **Supported Databases**: MySQL, PostgreSQL
- **Scripts**:
    - **ttrpg_mySQL.sql**: SQL script for setting up the MySQL database schema and tables.
    - **ttrpg_postgres.sql**: SQL script for setting up the PostgreSQL database schema and tables.

#### TTRPG Schema

The database schema for the TTRPG system is composed of several entities, each representing a distinct aspect of the game. Below is a detailed explanation of every entity and its fields.

##### Entity: `allowed_item`
- **class_id** (integer, Primary Key, Foreign Key to `class(id)`): Identifier for the class.
- **item_type** (character(255)): Type of item allowed for the class.

##### Entity: `base_stats`
- **id** (integer, Primary Key): Unique identifier for the base stats record.
- **vitality** (integer): Character's vitality.
- **strength** (integer): Character's strength.
- **dexterity** (integer): Character's dexterity.
- **arcane** (integer): Character's arcane ability.
- **instinct** (integer): Character's instinct.
- **charisma** (integer): Character's charisma.
- **speed** (integer): Character's speed.

##### Entity: `chara`
- **id** (integer, Primary Key): Unique identifier for the character.
- **info_id** (integer, Foreign Key to `character_info(id)`): Identifier for character's information.
- **age** (integer): Character's age.
- **name** (character varying(50)): Character's name.
- **region_id** (integer, Foreign Key to `region(id)`): Identifier for the character's region.
- **race_id** (integer, Foreign Key to `race(id)`): Identifier for the character's race.
- **lvl_up_stat_id** (integer, Foreign Key to `base_stats(id)`): Identifier for the level-up stats of the character.

##### Entity: `character_classes`
- **character_id** (integer, Primary Key, Foreign Key to `chara(id)`): Identifier for the character.
- **class_id** (integer, Primary Key, Foreign Key to `class(id)`): Identifier for the class.

##### Entity: `character_info`
- **id** (integer, Primary Key): Unique identifier for the character information.
- **lvl** (integer): Character's level.
- **current_hp** (integer): Character's current hit points.
- **shield** (integer): Character's shield points.
- **max_hp** (integer): Character's maximum hit points.
- **current_mp** (integer): Character's current magic points.
- **current_ki** (integer): Character's current ki points.
- **current_fury** (integer): Character's current fury points.
- **current_miracles** (integer): Character's current miracles.
- **current_metamorphs** (integer): Character's current metamorphs.

##### Entity: `character_skills`
- **character_id** (integer, Primary Key, Foreign Key to `chara(id)`): Identifier for the character.
- **total_uses** (integer, default 0): Total uses of the skill.
- **status** (integer): Status of the skill.
- **unlocked_skill_id** (integer, Foreign Key to `skill(id)`): Identifier for the unlocked skill.
- **temp_uses** (integer): Temporary uses of the skill.

##### Entity: `characters_tree_points`
- **character_id** (integer, Primary Key, Foreign Key to `chara(id)`): Identifier for the character.
- **tree_id** (integer, Primary Key, Foreign Key to `tree(id)`): Identifier for the tree.
- **available_points** (integer): Available points in the tree.

##### Entity: `class`
- **id** (integer, Primary Key): Unique identifier for the class.
- **name** (character varying(50)): Name of the class.
- **description** (character varying(150)): Description of the class.
- **tree_id** (integer, Foreign Key to `tree(id)`): Identifier for the skill tree.
- **stats_id** (integer, Foreign Key to `base_stats(id)`): Identifier for the base stats of the class.

##### Entity: `inventory`
- **character_id** (integer, Primary Key, Foreign Key to `chara(id)`): Identifier for the character.
- **item_id** (integer, Primary Key, Foreign Key to `item(id)`): Identifier for the item.
- **equipped** (boolean, default false): Indicates if the item is equipped.
- **stacks** (integer): Number of stacks of the item.

##### Entity: `item`
- **id** (integer, Primary Key): Unique identifier for the item.
- **name** (character varying(255)): Name of the item.
- **description** (character varying(255)): Description of the item.
- **type** (character(255)): Type of the item.
- **main_skill_id** (integer, Foreign Key to `skill(id)`): Identifier for the main skill of the item.
- **weight** (double precision): Weight of the item.
- **stackable** (boolean, default false): Indicates if the item is stackable.

##### Entity: `item_skill`
- **item_id** (integer, Primary Key, Foreign Key to `item(id)`): Identifier for the item.
- **skill_id** (integer, Primary Key, Foreign Key to `skill(id)`): Identifier for the skill.

##### Entity: `race`
- **id** (integer, Primary Key): Unique identifier for the race.
- **name** (character varying(50)): Name of the race.
- **description** (character varying(150)): Description of the race.
- **stat_id** (integer, Foreign Key to `base_stats(id)`): Identifier for the base stats of the race.
- **level_up_hp** (integer, default 0): Hit points gained per level-up.

##### Entity: `race_region`
- **race_id** (integer, Primary Key, Foreign Key to `race(id)`): Identifier for the race.
- **region_id** (integer, Primary Key, Foreign Key to `region(id)`): Identifier for the region.

##### Entity: `race_skill`
- **race_id** (integer, Primary Key, Foreign Key to `race(id)`): Identifier for the race.
- **skill_tree_id** (integer, Primary Key, Foreign Key to `tree(id)`): Identifier for the skill tree.
- **slot** (integer): Slot for the skill tree.

##### Entity: `region`
- **id** (integer, Primary Key): Unique identifier for the region.
- **name** (character varying(50)): Name of the region.
- **description** (character varying(150)): Description of the region.

##### Entity: `skill`
- **id** (integer, Primary Key): Unique identifier for the skill.
- **name** (character varying(50)): Name of the skill.
- **description** (character varying(150)): Description of the skill.
- **type** (character(255)): Type of the skill.
- **cost** (integer): Cost of using the skill.
- **cost_type** (character(255)): Type of cost for using the skill.
- **skill_family_id** (integer, Foreign Key to `skill_family(id)`): Identifier for the skill family.
- **skil_family_rank** (integer): Rank within the skill family.

##### Entity: `skill_family`
- **id** (integer, Primary Key): Unique identifier for the skill family.

##### Entity: `skill_modifier`
- **id** (integer, Primary Key): Unique identifier for the skill modifier.
- **skill_id** (integer, Foreign Key to `skill(id)`): Identifier for the skill.
- **is_malus** (smallint, default 0): Indicates if the modifier is a penalty.
- **is_area** (smallint, default 1): Indicates if the modifier affects an area.
- **target_num** (integer, default 1): Number of targets affected by the modifier.
- **target_type** (character(255)): Type of targets affected by the modifier.
- **stat_target** (character(255)): Stat targeted by the modifier.
- **stat_flat** (integer): Flat stat value affected by the modifier.
- **stat_scaling** (character(255)): Stat scaling type.
- **stat_max_scaling** (integer): Maximum stat scaling value.
- **stat_type** (character(255)): Type of stat affected by the modifier.

##### Entity: `skill_modifier_dices`
- **skill_modifier_id** (integer, Primary Key, Foreign Key to `skill_modifier(id)`): Identifier for the skill modifier.
- **times** (integer, default 1): Number of times the dice is rolled.
- **faces** (integer): Number of faces on the dice.

##### Entity: `tree`
- **id** (integer, Primary Key): Unique identifier for the tree.
- **name** (character varying(50)): Name of the tree.
- **description** (character varying(150)): Description of the tree.

##### Entity: `tree_skills`
- **tree_id** (integer, Primary Key, Foreign Key to `tree(id)`): Identifier for the tree.
- **skill_family_id** (integer, Primary Key, Foreign Key to `skill_family(id)`): Identifier for the skill family.
- **parent_skill_family_id** (integer, nullable): Identifier for the parent skill family.

## License

This project is licensed under the Attribution-NonCommercial-NoDerivatives 4.0 International License. See the [LICENSE.md](LICENSE.md) file for details.

## Developers

The Juggle Hive Development Team has made this project possible. You can find more about the team and their profiles below:

- **Davide Gritta**: [GitHub Profile](https://github.com/GrittaGit)
- **Gianluca Rossetti**: [GitHub Profile](https://github.com/Ross9519)