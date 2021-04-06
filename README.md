# social-network-kata

- Posting: Alice can publish messages to a personal timeline. Message must be less than 280 characters
- Block: Bob can block Alice
- Following: Alice can follow Bob (if Bob has Block Alice then she can't)
- Reading: Alice can view Bob’s timeline (if Bob has Block Alice then she can't)

## Evitar las relaciones many to many

segun eric evans hay que evitar las relaciones many to many porque son muy complejas.
Lo que podes hacer es dejar la relacion de un solo lado o que la entidad que representa el join
sea un agregate en si mismo.

- `According Eric Evans' book, many to many associations make your model too complex`
https://stackoverflow.com/a/7021119/7698720

- `and instead have a method on your campaign repository which retrieves all publishers for a given campaign.`
https://stackoverflow.com/a/4920086/7698720

- ` It could also be that the join table is an aggregate of its own (the relationship between user and role being a thing that has a life cycle of its own, possibly with its own rules).`
https://softwareengineering.stackexchange.com/a/401606

- `Our model could be mapped into three different databases without changing any line of code. This is an important point for scalability`
https://apiumhub.com/tech-blog-barcelona/orm-avoid-using-many-relationships/

- `For the same reason, you should avoid unbounded one-to-many associations (collections) since these can grow large over time.`
  https://vaadin.com/learn/tutorials/ddd/tactical_domain_driven_design

