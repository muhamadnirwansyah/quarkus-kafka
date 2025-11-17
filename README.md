# Cara Menjalankan Project
disini ada 2 service

1. notification-service
2. polis-service

# Start Kafka (Docker)


<img width="2310" height="180" alt="image" src="https://github.com/user-attachments/assets/5e777dfd-3977-46c5-ace7-d58c06ca6aff" />


<img width="814" height="608" alt="image" src="https://github.com/user-attachments/assets/27c91339-a748-4549-8b7b-b0a6ddad93b0" />

# Jalankan polis-service & notification service
masuk ke terminal dan arahkan ke dalam source project polis-service/notification-service. 
kemudian ketik ini di terminal `./mvnw quarkus:dev`
atau jika menggunakan IDE intellij IDEA bisa langsung buat profile baru dan click running masing-masing service


<img width="385" height="179" alt="image" src="https://github.com/user-attachments/assets/c2204d8a-cb24-492a-ac4b-2414c8882347" />

jika berhasil, maka logs nya akan seperti ini

<img width="2784" height="994" alt="image" src="https://github.com/user-attachments/assets/30c8938f-93a6-4373-a2ac-19e85e2562f2" />

<img width="2778" height="1000" alt="image" src="https://github.com/user-attachments/assets/40a09340-2a65-45b1-a6fa-5446504835d0" />

# Testing Api & Flow

<img width="791" height="582" alt="image" src="https://github.com/user-attachments/assets/1506d52e-51eb-43e4-83c0-74b454944775" />

logs producer send event 

<img width="2772" height="804" alt="image" src="https://github.com/user-attachments/assets/61ea61e1-cd7d-46dc-8602-9fe3ac982889" />

log consumer receive event

<img width="2768" height="996" alt="image" src="https://github.com/user-attachments/assets/be792879-8ec4-409a-b500-1a2f147a5436" />

check logs by offset

<img width="2336" height="1508" alt="image" src="https://github.com/user-attachments/assets/c4436cd4-8048-4ed0-a6bd-c0b66cf883e2" />

check by database table polis & table inbox

<img width="1434" height="576" alt="image" src="https://github.com/user-attachments/assets/a327eb77-ebfe-40ba-8856-b598722e621f" />

<img width="1412" height="530" alt="image" src="https://github.com/user-attachments/assets/0fdc90b0-ad55-40bb-9b7b-14d9693da87f" />









