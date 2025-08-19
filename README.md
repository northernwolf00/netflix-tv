# Kotlin Android TV “Netflix” Clone

A polished, production-ready reference app for Android/Google TV built with Kotlin. It demonstrates a modern TV streaming UX (home rows, details, playback, search, profiles) using Jetpack libraries, Clean Architecture, and ExoPlayer—ready to plug into your own catalog API (e.g., TMDB) or a backend you control.

---

## ✨ Features

* **TV-first UI**

  * Hero carousel, rail/row browsing, continue-watching, and genre shelves
  * Details page with seasons/episodes, cast & crew, similar titles
  * Global search & Assistant voice search (on supported devices)
  * TV recommendations (channels/watch-next)
  * Remote & D-pad friendly focus with smooth scaling and focus highlights
* **Playback**

  * ExoPlayer with adaptive HLS/DASH, playback speed, subtitles/CC, audio tracks
  * Resume position, next-episode autoplays, skip intro/recap hooks
* **Account & Profiles**

  * Lightweight profile switcher (adult/kids), watchlist, ratings
* **Data**

  * Paging 3 infinite lists, offline cache with Room, OkHttp caching
* **Quality**

  * MVVM + Clean Architecture + DI (Hilt)
  * Unit/UI tests (JUnit5, Turbine, Robolectric, Macrobenchmark)
  * Crash/analytics hooks (Firebase optional)
* **Nice-to-have**

  * Dynamic color theming for TV, day/night, high-contrast accessibility mode
  * Localization & RTL ready

---

## 🧱 Tech Stack

* Language: **Kotlin**, Coroutines/Flow
* UI: **Jetpack Compose for TV** (or Leanback variant; see flavors)
* Media: **ExoPlayer**
* DI: **Hilt**
* Data: **Retrofit**, **OkHttp**, **Moshi**, **Room**, **DataStore**
* Lists: **Paging 3**
* Navigation: **Jetpack Navigation**
* Testing: **JUnit5**, **Robolectric**, **MockK**, **Turbine**, **Espresso**, **Macrobenchmark**
* Build: **Gradle Kotlin DSL**

---

## 🗂 Project Structure

```
app/                         # Android TV app (Compose for TV shell, navigation)
core-ui/                     # TV components: rails, carousels, focus effects
core-model/                  # Immutable models (Movie, Show, Episode, UserProfile, etc.)
core-network/                # Retrofit/Moshi services, DTOs, interceptors
core-database/               # Room entities/DAOs, migrations
core-data/                   # Repos combining network+db, mapping DTO<->model
feature-home/                # Home rails, continue watching, genres
feature-details/             # Title details, seasons/episodes, recommendations
feature-player/              # Player screen, controls, subtitles, next-episode
feature-search/              # Text & voice search, results
feature-profile/             # Profile picker, watchlist, ratings
benchmark/                   # Macrobenchmarks
build-logic/                 # Convention plugins, common configs
```

**Architecture (Clean + MVVM)**

```
UI (Compose for TV)  <->  ViewModel  <->  UseCases  <->  Repositories  <->  (Network + DB)
                               ↑             │
                              Hilt         Mappers
```

---

## 🚀 Getting Started

### Prereqs

* Android Studio Jellyfish/Koala+
* JDK 17
* Android TV emulator *or* physical device (Chromecast with Google TV, Shield, etc.)

### 1) Clone

```bash
git clone https://github.com/your-org/kotlin-tv-netflix-clone.git
cd kotlin-tv-netflix-clone
```

### 2) Configure Secrets

Create `local.properties` (or use Gradle properties/`dotenv`) and set your API keys:

```
TMDB_API_KEY=YOUR_KEY
BACKEND_BASE_URL=https://your.backend/api/
```

Optionally add Firebase `google-services.json` to `app/` if you enable analytics/crashlytics.

### 3) Run

```bash
./gradlew :app:installDebug
adb shell monkey -p com.yourorg.tvclone 1
```

Or use **Run** ▶ in Android Studio on an **Android TV** device/emulator.

---

## 🧭 Flavors

* `composeTv` (default): Jetpack **Compose for TV**
* `leanback`: classic **Leanback** fragments

Switch with Build Variants or:

```bash
./gradlew :app:assembleComposeTvDebug
./gradlew :app:assembleLeanbackDebug
```

---

## 🎮 Remote Controls & Key Mapping

| Action            | Key / Button                           |
| ----------------- | -------------------------------------- |
| Move focus        | DPAD\_UP/DOWN/LEFT/RIGHT               |
| Select            | DPAD\_CENTER / ENTER                   |
| Back              | BACK                                   |
| Play/Pause        | MEDIA\_PLAY\_PAUSE                     |
| Fast Seek ±       | MEDIA\_FAST\_FORWARD / MEDIA\_REWIND   |
| Next/Prev episode | MEDIA\_NEXT / MEDIA\_PREVIOUS          |
| Info / Details    | BUTTON\_Y (controllers), long-press OK |

Focus is handled via Compose for TV `Focusable` + custom scale/shine effects. Components have large touch targets (≥ 48dp) and clear focus rings.

---

## 📺 UI/UX Notes

* Rails use **LazyRow** with snap & center zoom.
* Title cards preload artwork on focus for instant details panel.
* Details page shows: synopsis, metadata chips, cast, season picker, episodes list, and “More like this”.
* Player overlay: timeline with thumbnails, CC/Audio button, “Next episode in 5…”, intro/recap skip hooks.
* Kids profile uses restricted catalog + simplified palette.

---

## 🔊 Voice & Search

* Text search: query suggestions + debounced results with Paging 3.
* Voice: integrates with **TV Assistant** via `android.intent.action.SEARCH` and `SearchableInfo`.
* Recommendations: **Watch Next** and **Channels** via `TvContractCompat` and `Recommendation` APIs.

---

## 🎥 Playback (ExoPlayer)

* DRM-ready (Widevine L3/L1; plug your license server).
* HLS/DASH with adaptive ABR; cue points for intro/credits.
* Subtitle formats: WebVTT/TTML/SRT (muxed or sidecar).
* Persisted resume positions and per-profile watch history.

---

## 🔐 Auth & Profiles (Optional)

* Email/pass or OAuth provider (Google Sign-In TV).
* Multiple profiles with content restrictions (kid/teen/adult).
* DataStore for local profile prefs; tokens stored in `EncryptedSharedPreferences`.

---

## 🧪 Testing

```bash
./gradlew testDebugUnitTest
./gradlew connectedDebugAndroidTest
./gradlew :benchmark:connectedCheck
```

* Unit: ViewModels, UseCases, Repos (MockK, Turbine for Flows)
* UI: Compose testing, Espresso for Leanback flavor
* Performance: Startup, scroll/jank, cold/warm launch benchmarks

---

## 📈 Analytics & Quality

* Optional Firebase Analytics/Crashlytics hooks (events: play\_start, play\_complete, add\_to\_watchlist, search\_query)
* StrictMode + baseline profiles
* Detekt + Ktlint + ktfmt
* Proguard/R8 rules included

Run static checks:

```bash
./gradlew detekt ktlintCheck
```

---

## ⚙️ Configuration

`app/src/main/assets/remote_config.json` (example):

```json
{
  "hero_autoplay": true,
  "max_rows": 12,
  "enable_kids_profile": true,
  "enable_voice_search": true
}
```

---

## 🌐 Networking

* `Retrofit` + `OkHttp` with:

  * Auth & API-key interceptors
  * Disk cache (10–50 MB) and `Cache-Control` respect
  * Retry/backoff for flaky connections
* DTO ↔ Model mappers in `core-data`
* Replace `TMDBService` with your backend—only `Repository` contracts are consumed by UI.

---

## 🗃 Offline & Caching

* Room entities for titles, images, seasons, episodes, continue-watching
* PagingSource combines local + remote (RemoteMediator)
* Poster/backdrop prefetch on focus to avoid jank
* Glide/Coil cache configured for TV memory constraints

---

## 🔧 Environment & Build

* Gradle Kotlin DSL, version catalogs `libs.versions.toml`
* BuildConfig flags per flavor:

  * `FEATURE_KIDS`, `FEATURE_RECOMMENDATIONS`, `FEATURE_VOICE`
* Keystore (release):

  * Place in `keystores/release.jks`, set in `~/.gradle/gradle.properties`:

    ```
    RELEASE_STORE_FILE=keystores/release.jks
    RELEASE_STORE_PASSWORD=****
    RELEASE_KEY_ALIAS=tvclone
    RELEASE_KEY_PASSWORD=****
    ```

---

## ♿ Accessibility

* High-contrast theme toggle
* Large focus ring & scale animations (motion-reduced variant)
* Content descriptions for cards & controls
* Subtitle styling, audio descriptions hook

---

## 🧩 Extensibility Ideas

* Downloads for offline (where permitted)
* Continue watching syncing across devices
* Multi-CDN failover
* Personalized rails (on-device ranking)
* Parental PIN & time limits

---

## 🛡️ Content & DRM

This project ships **no media**. Use your own catalog and ensure you have distribution rights. For DRM streams, configure Widevine license URLs in `PlaybackConfig`.

---

## 🐛 Troubleshooting

* **No focus visible?** Verify you’re on a TV device (not phone), and `useTVFocus` modifiers are applied.
* **Stutter on hero row?** Reduce card elevation/blur, enable baseline profiles, check image sizes.
* **Voice search not working?** Confirm `SearchableActivity` intent filters and Assistant availability on device.

---

## 🤝 Contributing

PRs welcome! Please run `./gradlew detekt ktlintFormat testDebugUnitTest` before submitting. Follow conventional commits.



