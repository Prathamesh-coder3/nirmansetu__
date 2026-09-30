# NirmaanSetu — Vercel Services Deployment

## 1. Repository

Push this entire folder as **one GitHub repository**.

The repository root must contain:

```text
vercel.json
frontend/
backend/
```

Do **not** set the Vercel Root Directory to `frontend` or `backend`.

## 2. Vercel project

Import the single GitHub repository into **one Vercel project**.

Use the **Services** architecture. Do not use the single-container preset for this ZIP.

The root `vercel.json` defines:

```text
frontend service → frontend/
backend service  → backend/
```

The backend service uses:

```text
runtime: container
entrypoint: Dockerfile.vercel
```

## 3. Routing

```text
https://YOUR-APP.vercel.app/
        ↓
    frontend service
```

```text
https://YOUR-APP.vercel.app/api/health
        ↓
    backend service
```

The API rewrite must appear before the frontend catch-all.

## 4. Backend container

The backend service Dockerfile is:

```text
backend/Dockerfile.vercel
```

Its service root is `backend/`, so Docker paths are backend-relative.

The container:

- builds with Java 21 + Maven
- runs the Spring Boot executable JAR
- listens on `PORT`
- binds Spring Boot to `0.0.0.0`
- defaults to port 80 inside the service container

The normal local Spring Boot fallback remains port 8080 when running with Maven outside Vercel.

## 5. Frontend API

The frontend uses a same-origin API base:

```text
/api
```

Do not change production source code to a separate backend URL.

## 6. Environment variables

Set backend secrets in Vercel only.

Typical demo variables:

```text
SPRING_PROFILES_ACTIVE=dev
DEMO_MODE=true
JWT_SECRET=<strong-secret>
JWT_EXPIRATION_MS=3600000
```

For production PostgreSQL, configure the documented database variables and activate the production profile.

Never expose backend secrets with `VITE_*` variables.

## 7. Local verification

Frontend:

```bash
cd frontend
npm ci
npm run build
```

Backend:

```bash
cd backend
mvn clean package -DskipTests
```

## 8. Vercel CLI

From the repository root, use the latest Vercel CLI for Services support:

```bash
npm install -g vercel@latest
vercel --version
vercel dev
```

`vercel dev` should run the services from the root project.

## 9. GitHub

```bash
git init
git add .
git commit -m "Prepare NirmaanSetu for Vercel Services"
git branch -M main
git remote add origin YOUR_REPOSITORY_URL
git push -u origin main
```

## 10. Vercel import

1. Create/import one Vercel project from the GitHub repository.
2. Keep the Root Directory at the repository root.
3. Keep `vercel.json` at the root.
4. Select/configure **Services**, with the repository root as the project root.
5. Do not select `frontend/` or `backend/` as the Vercel Root Directory.
6. The project should show both services: `frontend` and `backend`.
7. Deploy.

## 11. Post-deployment checks

Open:

```text
/
```

Then test:

```text
/api/health
```

Also test login, registration, dashboard, worker pages, government pages, projects, training, applications, and language switching.
