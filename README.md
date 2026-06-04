# 🤖 Jarvis - Android AI Assistant

Jarvis ist ein intelligenter KI-Assistent für Android mit Spracherkennung, Text-to-Speech und Smart Home Integration.

## Features

✅ **Sprachassistant**
- 🎤 Spracheingabe (Speech Recognition)
- 🔊 Sprachausgabe (Text-to-Speech)
- 💬 Natürliche Konversation

✅ **Verfügbare Befehle**
- 📞 Anrufen (Call Contacts)
- 💬 SMS senden
- 🌤️ Wetter abrufen
- ⏰ Wecker stellen
- 🏠 Smart Home Steuerung
- 📰 Nachrichten abrufen
- 🕐 Uhrzeit

✅ **Benutzeroberfläche**
- Material Design 3
- Dark Mode Support
- Responsive Layout
- Jetpack Compose

## Anforderungen

- Android 7.0+ (API 24)
- Kotlin
- Android Studio Giraffe+

## Installation

### 1. Repository klonen
```bash
git clone https://github.com/thielp112/jarvis-android.git
cd jarvis-android
```

### 2. Android Studio öffnen
- Öffne das Projekt in Android Studio
- Warte auf Gradle Sync

### 3. API Keys konfigurieren
Erstelle eine `local.properties` Datei im Projekt-Root:
```properties
WEATHER_API_KEY=dein_openweathermap_api_key
NEWS_API_KEY=dein_newsapi_key
```

### 4. App starten
- Verbinde dein Android-Gerät oder nutze den Emulator
- Klicke auf "Run"

## Struktur

```
jarvis-android/
├── src/main/kotlin/com/jarvis/assistant/
│   ├── ui/
│   │   ├── screens/     # UI Screens
│   │   └── theme/       # Themes & Styling
│   ├── data/
│   │   ├── models/      # Data Models
│   │   ├── api/         # API Services
│   │   └── repository/  # Data Repository
│   ├── viewmodel/       # ViewModels
│   └── utils/           # Utilities
└── build.gradle.kts     # Dependencies
```

## Verwendung

### Sprachbefehle
1. Klicke auf das Mikrofon-Icon
2. Sprich deinen Befehl
3. Jarvis führt den Befehl aus

### Textbefehle
1. Tippe deinen Befehl in das Eingabefeld
2. Klicke auf Send
3. Jarvis antwortet

### Menü-Befehle
1. Klicke auf das Menü-Icon
2. Wähle einen Befehl aus
3. Jarvis führt ihn aus

## Berechtigungen

Jarvis benötigt folgende Berechtigungen:
- `RECORD_AUDIO` - Für Spracherkennung
- `INTERNET` - Für API Calls
- `ACCESS_FINE_LOCATION` - Für Wetter & Standort
- `CALL_PHONE` - Für Anrufe
- `SEND_SMS` - Für SMS
- `READ_CONTACTS` - Für Kontakte

## Abhängigkeiten

- **Jetpack Compose** - Modern UI Framework
- **Retrofit2** - HTTP Client
- **Google Play Services** - Location Services
- **Room** - Local Database
- **Coroutines** - Async Programming

## API Integration

### OpenWeatherMap API
- Abrufen von Wetterdaten
- Kostenlos mit Registrierung
- https://openweathermap.org/api

### NewsAPI
- Abrufen von Nachrichten
- Kostenlos mit Registrierung
- https://newsapi.org

## Zukünftige Features

- 🧠 Machine Learning Integration
- 🌐 Multi-Language Support
- 🗣️ Bessere Spracherkennung
- 🤝 Integration mit Google Assistant
- 📱 Widget Support
- 💾 Lokale Speicherung von Einstellungen

## Lizenz

MIT License

## Autor

**thielp112**
- GitHub: https://github.com/thielp112

## Support

Für Probleme oder Feature-Requests, erstelle bitte ein Issue auf GitHub.

---

**Viel Spaß mit Jarvis!** 🤖✨
