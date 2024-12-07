# DAY 15 WORKSHOP - Contacts List with Redis
- Create a webapp with the following functions
  - Show all contacts
  - Create new contact
  - Edit existing contact
  - Delete existing contact
- Should include validation for contact fields
- Connect to redis database for data persistance
  - Makes use of redis LIST
- Deploy to Railway (using Dockerfile)

## Request Mappings
### localhost:8080
- Landing page, redirects to localhost:8080/contacts

### localhost:8080/contacts
- List of contact names
- Each name is a hyperlink to the person's contact details

### localhost:8080/contacts/id
- An individual's contact details

### localhost:8080/contacts/create
- (GET) Create a new contact entry
- (POST) Handle the creation of a new contact

### localhost:8080/contacts/{id}/edit
- (GET) Edit an existing contact's details
- (POST) Handle the editing of an existing contact

### localhost:8080/contacts/{id}/delete
- (GET) Confirmation page to delete a contact's details
- (POST) Execution of delete
