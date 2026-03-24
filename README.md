# Mini Spotify

API REST desenvolvida em java com Spring Boot 

## Como rodar

Executar:
   ```bash
   ./mvnw spring-boot:run
   ```

E depois abrir em:
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

## Rotas básicas

### Usuários
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/usuarios` | Criar usuário |
| GET | `/usuarios` | Listar usuários ativos |
| GET | `/usuarios/{id}` | Buscar usuário por ID |
| PUT | `/usuarios/{id}` | Atualizar usuário |
| DELETE | `/usuarios/{id}` | Desativar usuário |

### Artistas
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/artistas` | Criar artista |
| GET | `/artistas` | Listar artistas ativos |
| GET | `/artistas/{id}` | Buscar artista por ID |
| PUT | `/artistas/{id}` | Atualizar artista |
| DELETE | `/artistas/{id}` | Desativar artista |

### Álbuns
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/albuns` | Criar álbum |
| GET | `/albuns` | Listar álbuns ativos |
| GET | `/albuns/{id}` | Buscar álbum por ID |
| PUT | `/albuns/{id}` | Atualizar álbum |
| DELETE | `/albuns/{id}` | Desativar álbum |

### Músicas
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/musicas` | Criar música |
| GET | `/musicas` | Listar músicas ativas |
| GET | `/musicas/{id}` | Buscar música por ID |
| PUT | `/musicas/{id}` | Atualizar música |
| DELETE | `/musicas/{id}` | Desativar música) |

### Playlists
| Método | Rota | Descrição               |
|--------|------|-------------------------|
| POST | `/playlists` | Criar playlist          |
| GET | `/playlists` | Listar playlists ativas |
| GET | `/playlists/{id}` | Buscar playlist por ID  |
| PUT | `/playlists/{id}` | Atualizar playlist      |
| DELETE | `/playlists/{id}` | Desativar playlist      |

### Histórico
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/historicos` | Registrar histórico |
| GET | `/historicos` | Listar todo o histórico |
| GET | `/historicos/{id}` | Buscar histórico por ID |
| GET | `/historicos/usuario/{id}` | Listar histórico de um usuário |
| PUT | `/historicos/{id}` | Atualizar histórico |
| DELETE | `/historicos/{id}` | Deletar histórico |

## Rotas com Regras de Negócio

### Reproduzir Música
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/musicas/{id}/reproduzir` | Reproduz uma música e incrementa o total de reproduções |


### Adicionar Música à Playlist
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/playlists/{playlistId}/musicas/{musicaId}` | Adiciona uma música a uma playlist |


### Top 10 Músicas Mais Reproduzidas
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/relatorios/top-musicas` | Retorna as 10 músicas mais reproduzidas em ordem decrescente |

A coleção importada do Postman está disponível nesse repositório numa pasta do mesmo nome.
