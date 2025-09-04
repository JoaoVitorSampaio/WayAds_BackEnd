# 📱 WayAds - Sistema de Mídia iDOOH

## 📚 Visão Geral

Este repositório contém o desenvolvimento do **WayAds**, um sistema de **mídia interativa iDOOH (In-door Out-of-Home)** voltado para carros de aplicativo (Uber, 99Pop, etc.).  

O aplicativo exibe uma **tela interativa para passageiros** durante a corrida, oferecendo:

- **Categorias de conteúdo** (Kids, Turismo, Gastronomia, Atualidades, Entretenimento)
- **Recomendações inteligentes** (restaurantes, pontos turísticos, notícias)
- **Integração com anúncios publicitários** (banner fixo, rodapé)
- **Geolocalização** para exibir anúncios e conteúdos relevantes de acordo com o raio de proximidade
- **QR Codes interativos** para levar o passageiro até promoções e links externos

---

## 🎯 Objetivos do Projeto

- ✅ Criar um sistema de entretenimento para passageiros em corridas de aplicativo  
- ✅ Aumentar a interação e engajamento através de conteúdo dinâmico  
- ✅ Gerar monetização via anúncios geolocalizados
- ✅ Gerar um relatório de métricas para as empresas anunciantes
- ✅ Implementar arquitetura escalável usando Flutter + API Backend  

---

## 🛠️ Linguagens e Tecnologias

- **Flutter/Dart** → desenvolvimento multiplataforma  
- **Provider / Riverpod** → gerenciamento de estado  
- **Dio / http** → consumo de API  
- **Hive / SQLite** → cache local offline  
- **Geolocator** → geolocalização em tempo real  
- **qr_flutter** → geração de QR Codes  
- **Firebase ou FastAPI/NestJS** → backend para anúncios e métricas  

<div style="display: inline_block"><br>
  <img align="center" alt="Flutter" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/flutter/flutter-original.svg" />
  <img align="center" alt="Dart" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/dart/dart-original.svg" />
  <img align="center" alt="Firebase" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/firebase/firebase-plain.svg" />
  <img align="center" alt="Android" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/android/android-original.svg" />
</div>

---

## 🏗️ Arquitetura do Projeto

👉 *(Espaço reservado – incluir futuramente o diagrama da arquitetura com Frontend, Backend, APIs e banco de dados)*

---

## 🚀 Como Executar

### 1. Clone o Repositório

```bash
git clone https://github.com/JoaoVitorSampaio/WayAds_BackEnd.git
cd WayAds_BackEnd
```

### 2. Instale o Flutter

Siga o guia oficial: [Instalação do Flutter](https://docs.flutter.dev/get-started/install)

### 3. Configure o Ambiente

Verifique se está tudo pronto com:

```bash
flutter doctor
```

### 4. Instale as Dependências

```bash
flutter pub get
```

### 5. Rode o Projeto

```bash
flutter run
```

---

## 📂 Estrutura Inicial do Código

```
lib/
 ├── main.dart          # ponto inicial do app
 ├── models.dart        # modelos de dados (Category, ContentItem, Ads)
 ├── home.dart          # tela principal com menu lateral
 ├── category_page.dart # listagem de conteúdos por categoria
```

---

## 🧪 Backlog do Projeto

O backlog foi estruturado em **Scrum** (com Sprints de 2 semanas).  
- **Sprint 1:** Estrutura base + CRUD anúncios + CRUD categorias + geolocalização básica  
- **Sprint 2:** Conteúdo expandido + segmentação de anúncios + métricas + QR Codes + modo kiosk  

---

## 👨‍💻 Equipe

- **Frontend:** 4 desenvolvedores  
- **Backend:** 5 desenvolvedores  
- **Metodologia:** Scrum com Sprints de 2 semanas  

---

## 🆘 Problemas Comuns

- **Erro `Flutter SDK not found`**  
  → Confirme que o `flutter/bin` está no seu PATH  

- **Erro ao rodar `flutter run`**  
  → Verifique se um emulador Android ou dispositivo físico está conectado  

- **Dependências não encontradas**  
  → Rode novamente:
  ```bash
  flutter pub get
  ```

---

## 🎨 UX/UI

Tela inicial do aplicativo: ![Tela Inicial](https://user-images.githubusercontent.com/.../ui_home.png)
