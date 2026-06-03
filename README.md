# 💪 Fitness Tracker API

Rastreamento de treinos com exercícios, séries, repetições e calorias.

## 📋 Sobre o Projeto

API para acompanhar a evolução nos treinos físicos. O usuário registra seus treinos com os exercícios realizados (séries, repetições, peso, calorias). Permite ver o histórico e comparar a evolução ao longo do tempo.

## ✨ Funcionalidades

- ✅ Registrar treino com data e tipo (STRENGTH, CARDIO, FLEXIBILITY)
- ✅ Adicionar exercícios ao treino (nome, séries, reps, peso)
- ✅ Calcular total de calorias do treino
- ✅ Histórico de treinos por data
- ✅ Evolução por exercício (comparar pesos ao longo do tempo)
- ✅ Duração do treino
- ✅ Treinos da semana

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/workouts` | Listar / Criar treino |
| GET | `/api/workouts/{id}` | Detalhes do treino |
| POST | `/api/workouts/{id}/exercises` | Adicionar exercício |
| GET | `/api/workouts/week` | Treinos da semana |
| GET | `/api/workouts/exercise/{name}` | Histórico por exercício |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · MySQL · Maven · Lombok
