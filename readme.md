# ✨ AI Background Remover Platform with Spring Boot + MySQL + React ⚡

An end-to-end full-stack platform to remove image backgrounds effortlessly using the ClipDrop API, with authentication via Clerk, payment integration via Razorpay, and built with modern tools like Spring Boot, MySQL, React, Tailwind CSS, and Vite.

---

## 🚀 Features

- 🧠 AI-powered image background removal (ClipDrop API)
- 🔐 Authentication via Clerk
- 💳 Secure payments using Razorpay
- ⚙️ Background task management and JWT security
- 🖼️ Stunning responsive UI with Tailwind CSS
- 📦 Full integration of React (Vite) frontend and Spring Boot backend
- 🎉 Realtime UI updates and toast notifications

---

## 🛠️ Project Setup Instructions

### 🧼 Initial Cleaning & Setup
1. Clean up the project
2. Add **Outfit** font to `index.css`
3. Update the **title** of the project
4. Change the **favicon**

---

## 🎨 Frontend (React + Vite + Tailwind CSS)

### 📦 Tailwind CSS Setup

```bash
npm install tailwindcss @tailwindcss/vite
```

- Configure in `vite.config.js`:
```js
import tailwindcss from '@tailwindcss/vite';
export default {
  plugins: [tailwindcss()],
};
```

- Import in global stylesheet:
```css
@import 'tailwindcss';
```

- ✅ Test Tailwind with a sample class!

---

### 🧭 Routing & Toast Setup

```bash
npm install react-router-dom react-hot-toast
```

- Wrap `<App />` with `<BrowserRouter />` in `main.jsx`
- Configure routes in `App.jsx`
- Add `<Toaster />` to show toast notifications

---

### 🎉 UI Components Breakdown

#### 🧭 Menu Bar
- Install icons:
```bash
npm install lucide-react
```
- Create `assets.js` and export images
- Build `MenuBar` component and mount in `App.jsx`

---

### 🏠 Home Page Structure

```txt
Home
├── Header
├── BgRemovalSteps
├── BgSlider
├── Pricing
├── Testimonials
└── TryNow
```

---

### 🪄 BgRemovalSteps Component

1. Update `assets.js`
2. Create `BgRemovalSteps.jsx`
3. Mount in `Home.jsx`

---

### 🌅 BgSlider Component

1. Update `assets.js`
2. Create `BgSlider.jsx`
3. Customize image slider and mount in `Home.jsx`

---

### 💸 Pricing Plans

1. Update `assets.js`
2. Create `Pricing.jsx`
3. Display available credit packages

---

### 🧑‍💬 Testimonials

1. Update `assets.js`
2. Create `Testimonials.jsx`
3. Add user reviews and feedback

---

### 🧪 Try Now

1. Create `TryNow.jsx`
2. Integrate real-time image background removal

---

## 🔐 Authentication with Clerk

1. Create a free [Clerk.dev](https://clerk.dev) account
2. Create an app and configure sign-in options
3. Copy the **Publishable Key**
4. Wrap app with `<ClerkProvider>` in `main.jsx`
5. Use Clerk components inside `MenuBar` to handle auth

---

## 🧠 Backend (Spring Boot)

### 🏗️ Project Structure

- Add necessary dependencies in `pom.xml`
- Use **JWT** for secure authentication
- Create user flow: Entity → DTO → Repository → Service → Controller

---

### 🔒 Security & JWT

1. Create JSON Web KeySet provider
2. Create JWT Auth filter
3. Add `SecurityConfig` class
4. Use annotations: `@Component`, `@Service`, `@Repository`

---

## 📬 Clerk Webhook Integration

1. Create webhook controller
2. Update `UserService` to handle webhook
3. Update Spring Security config
4. Load user into DB when Clerk signup completes

---

## 🌐 Ngrok for Webhook Tunneling

Use [Ngrok](https://ngrok.com/) to expose your local backend for Clerk webhook testing.

---

## 💳 Razorpay Integration (Backend)

1. Add Razorpay dependency in `pom.xml`
2. Store Razorpay keys in `application.properties`
3. Create:
   - Order Entity
   - Order Repository
   - Order DTO
   - Order Service
   - Order Controller

---

## 💵 Razorpay Integration (Frontend)

1. Store Razorpay Key in `.env`
2. Create `OrderService.js`
3. Integrate Razorpay checkout in `Pricing.jsx`
4. Trigger `buyCredits()` on button click

---

## 🔁 User State Management

1. Create global `AppContext`
2. Add `UserSyncHandler` component to sync user info
3. Use context in `Menubar`, `TryNow`, etc.

---

## 🧠 ClipDrop API Integration

1. Create a ClipDrop account and get API key
2. Add dependencies in `pom.xml`
3. Create:
   - Feign Client for ClipDrop
   - Controller for image removal endpoint
4. Update React:
   - Header component to upload image and call API
   - TryNow to preview and download result
   - State handled via `AppContext`

---

## 🧠 JDBC & Spring Boot Annotations (Mini Guide)

- JDBC = Java Database Connectivity
- Manual SQL + connection management
- Spring Boot uses annotations like `@Component`, `@Service`, `@Repository` to manage dependency injection automatically
- Eliminates the need to manually create objects

---

## 📁 Folder Structure

```txt
project-root/
├── client/           # React frontend
│   ├── src/
│   └── public/
├── server/           # Spring Boot backend
│   └── src/main/java/
├── .env
└── README.md
```

---

## 🙌 Credits

- 🧠 Built with React + Vite + Tailwind
- 🔐 Auth powered by Clerk
- 🤖 Background removal via ClipDrop API
- 💳 Payments via Razorpay
- ☕ Backend in Spring Boot

---

## 📣 Final Note

This project is a great example of modern full-stack development, combining elegant frontend design with powerful backend APIs. Whether you're looking to learn or launch, you're covered. ❤️

---

### 🧑‍💻 Developed by: **Jayasai Gorre**

