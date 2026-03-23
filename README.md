# Mini Spotify

API REST desenvolvida em java com Spring Boot 

## Como rodar

Executar:
   ```bash
   ./mvnw spring-boot:run
   ```

E depois abir em:
   ```
   http://localhost:8080
   ```
 
---

## Entidades

- Usuário
- Artista
- Álbum
- Música
- Playlist

---

## Rotas

### Usuários
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/usuarios` | Criar usuário |
| GET | `/usuarios` | Listar usuários ativos |
| GET | `/usuarios/{id}` | Buscar usuário por ID |
| PUT | `/usuarios/{id}` | Atualizar usuário |
| DELETE | `/usuarios/{id}` | Desativar usuário (exclusão lógica) |

### Artistas
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/artistas` | Criar artista |
| GET | `/artistas` | Listar artistas ativos |
| GET | `/artistas/{id}` | Buscar artista por ID |
| PUT | `/artistas/{id}` | Atualizar artista |
| DELETE | `/artistas/{id}` | Desativar artista (exclusão lógica) |

### Álbuns
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/albuns` | Criar álbum |
| GET | `/albuns` | Listar álbuns ativos |
| GET | `/albuns/{id}` | Buscar álbum por ID |
| PUT | `/albuns/{id}` | Atualizar álbum |
| DELETE | `/albuns/{id}` | Desativar álbum (exclusão lógica) |

### Músicas
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/musicas` | Criar música |
| GET | `/musicas` | Listar músicas ativas |
| GET | `/musicas/{id}` | Buscar música por ID |
| PUT | `/musicas/{id}` | Atualizar música |
| DELETE | `/musicas/{id}` | Desativar música (exclusão lógica) |

### Playlists
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/playlists` | Criar playlist |
| GET | `/playlists` | Listar playlists ativas |
| GET | `/playlists/{id}` | Buscar playlist por ID |
| PUT | `/playlists/{id}` | Atualizar playlist |
| DELETE | `/playlists/{id}` | Desativar playlist (exclusão lógica) |
