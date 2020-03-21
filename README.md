# POC_Excercise
An Android proficiency excercise
The exercise involves build a “proof of concept” app which consumes a REST service and displays photos with
headings and descriptions.

Specification :

1. Ingests a json feed from https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json
  - The feed contains a title and a list of rows.
  - You can use a third party json parser to parse this if desired.
2. Displays the content (including image, title and description) in a ListView
  - The title in the ActionBar should be updated from the json data.
  - Each row should be dynamically sized to the right height to display its content - no clipping, no
extraneous white-space etc. This means some rows will be larger than others.
3. Loads the images lazily (don’t download them all at once, but only as needed).
4. Implement a refresh function allowing the data & view to be updated
  - Used pull down to refresh.
5. Should not block UI when loading the data from the json feed.
6. Each row of the table look like the screenshots added.

Coding patterns :

1. Kotlin for programming language
2. MVVM Architecture with DataBinding support
3. Repository pattern for handling business logic
4. ROOM Persistence for local SQLite database connection
5. Binder pattern used for UI data logic
6. Builder pattern used for RecyclerView Adapter
7. Kotlin DSL implementation
8. Kotlin Extensions functions

Additionally :
1. The list should scroll smoothly. As much data as possible should be cached.
2. Comments code where necessary.
3. Polish code as much as possible.
4. Include at least two UI unit tests; one that asserts the state of the screen when set up with all data present,
and one that asserts the state of the screen when in an error state.
5. Handle screen rotation efficiently.
6. Used best-practice open-source libraries
  - AppCompat : Support library provided by Google for backward compatibility
  - Core-Ktx : Core library with Kotlin extension support used in this project
  - ConstraintLayout : Constraint layout for UI screen designing to reduce nested hierarchy
  - Material : Material design library
  - Lifecycle-Extensions : Used for ViewModel & LiveData related dependencies
  - Glide : Lazy loading image processing library to load list of images from network
  - Retrofit : HTTP client library for REST API calls
  - ROOM : ORM mapping persistence library for local database connection support
  - SwipeRefreshLayout : Provides ability to pull down to refresh UI content
