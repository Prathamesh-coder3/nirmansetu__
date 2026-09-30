# NirmaanSetu — Vercel Services Deployment

## IMPORTANT: create/rename the Vercel project

The previous deployment failed before the backend Docker build because Vercel generated this invalid container image reference:

`vcr.vercel.com/prathmeshbanchhod-5847/nirmansetu../api:...`

The `..` makes the OCI/Docker image reference invalid.

This package uses the safe project name:

`nirmaansetu`

When creating the Vercel project, use a project name containing only lowercase letters/numbers/hyphens, for example:

`nirmaansetu`

Do NOT reuse a Vercel project whose name ends with a dot or otherwise produces `nirmansetu../...`.

If the existing Vercel project has the bad name, rename it in:
Vercel Dashboard → Project → Settings → General → Project Name

Or create a fresh project named `nirmaansetu`.

## Vercel mode

Use Vercel **Services**.

Keep the project Root Directory at the repository root.

The root directory must contain:

```text
vercel.json
frontend/
backend/
```

Do NOT set the root directory to `frontend/` or `backend/`.

## Services

```text
frontend
root: frontend/
framework: vite

backend
root: backend/
runtime: container
entrypoint: Dockerfile.vercel
```

Routing:

```text
/api       -> backend
/api/*     -> backend
everything -> frontend
```

## GitHub

Push the extracted `NirmaanSetu` folder as ONE Git repository.

Do not create nested Git repositories inside `frontend/` or `backend/`.

## Vercel environment variables

Configure backend secrets in Vercel Project Settings, not in Vite public variables.

Examples:

```text
JWT_SECRET
JWT_EXPIRATION_MS
DATABASE_URL
DATABASE_USERNAME
DATABASE_PASSWORD
DEMO_MODE
SPRING_PROFILES_ACTIVE
```

Use only the variables that the application's real production configuration requires.

## Verification

The backend health endpoint is:

`/api/health`

After deployment, verify:

`https://<your-project>.vercel.app/api/health`

The frontend should load at:

`https://<your-project>.vercel.app/`

## Local checks

Frontend:

```bash
cd frontend
npm ci --include=optional
npm run build
```

Backend:

```bash
cd backend
mvn clean package -DskipTests
```

## Important note about the previous error

The error:

`invalid reference format`

appeared in the Vercel Buildah command while constructing the image tag. It happened before a Dockerfile instruction could execute. Therefore changing application code or the Spring Boot main class alone cannot fix that specific error. The Vercel project/service naming must produce a valid registry repository reference.
