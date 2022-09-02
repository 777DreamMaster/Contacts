# Contacts

## Details  
The application to create/update/delete contacts (like on the mobile phone) and search for people or organizations. App uses serialization for saving data in file. 
A contact can be a person or an organisation. A person has different attributes to a company thus the need to separate them. For example a persorn has gender but an organisation does not.

## Example
```
[menu] Enter action (add, list, search, count, exit): > add
Enter the type (person, organization): > person
Enter the name: > John
Enter the surname: > Smith
Enter the birth date: > 2000.10.15
Enter the gender (M, F): > M
Enter the number: > +0 (123) 456-789-ABcd
The record added.

[menu] Enter action (add, list, search, count, exit): > add
Enter the type (person, organization): > organization
Enter the organization name: > Decent Pizza Shop
Enter the address: > Wall St. 1
Enter the number: > +0 (123) 456-789-9999
The record added.

[menu] Enter action (add, list, search, count, exit): > count
The Phone Book has 6 records.

[menu] Enter action (add, list, search, count, exit): > search
Enter search query: > cent
Found 3 results:
1. Central Bank
2. Centurion Adams
3. Decent Pizza Shop

[search] Enter action ([number], back, again): > again
Enter search query: > shop
Found 2 results:
1. Decent Pizza Shop
2. Car shop

[search] Enter action ([number], back, again): > 2
Organization name: Car shop
Address: Wall St. 3
Number: +0 (123) 456-789-9999
Time created: 2018-01-01T00:03
Time last edit: 2018-04-29T11:34

[record] Enter action (edit, delete, menu): > edit
Select a field (name, address, number): > name
Enter name: > New Car Shop
Saved
Organization name: New Car Shop
Address: Wall St. 3
Number: +0 (123) 456-789-9999
Time created: 2018-01-01T00:03
Time last edit: 2018-11-20T11:04

[record] Enter action (edit, delete, menu): > menu

[menu] Enter action (add, list, search, count, exit): > search
Enter search query: > new
Found 1 result:
1. New Car Shop

[search] Enter action ([number], back, again): > back

[menu] Enter action (add, list, search, count, exit): > list
1. New Car Shop
2. Decent Pizza Shop
3. Central Bank
4. Centurion Adams
5. John Smith
6. Alice Wonderlanded

[list] Enter action ([number], back): > 6
Name: Alice
Surname: Wonderlanded
Birth date: [no data]
Gender: F
Number: +123123 (123) 12-23-34-45
Time created: 2018-03-12T11:21
Time last edit: 2018-03-12T11:21

[record] Enter action (edit, delete, menu): > edit
Select a field (name, surname, birth, gender, number): > number
Enter number: > +23 (321) 12-12 12 12
Saved
Name: Alice
Surname: Wonderlanded
Birth date: [no data]
Gender: F
Number: +23 (321) 12-12 12 12
Time created: 2018-03-12T11:21
Time last edit: 2018-11-20T11:07

[record] Enter action (edit, delete, menu): > menu

[menu] Enter action (add, list, search, count, exit): > exit
```
