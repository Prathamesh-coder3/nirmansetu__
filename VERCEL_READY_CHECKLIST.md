# NirmaanSetu — Vercel Services Ready Checklist

- [x] One GitHub repository
- [x] One Vercel project
- [x] Root `vercel.json` uses `services`
- [x] Frontend service rooted at `frontend/`
- [x] Backend service rooted at `backend/`
- [x] Backend service uses `runtime: container`
- [x] Backend service uses `Dockerfile.vercel`
- [x] API rewrite `/api/*` precedes frontend catch-all
- [x] Vite SPA fallback configured
- [x] Frontend API base uses `/api`
- [x] Spring Boot main class is `com.nirmaansetu.NirmaanSetuApplication`
- [x] Java 21
- [x] Spring Boot uses `0.0.0.0`
- [x] Spring Boot supports `PORT`
- [x] Backend Docker context is backend-only
- [x] Backend `.dockerignore` excludes build/cache/secrets
- [x] No root single-container Dockerfile that conflicts with Services
- [x] No nested Git repositories in source archive
- [x] No node_modules / target / dist in source archive

## Important

A Services deployment with a container backend still requires Vercel to build and push the backend container image. This ZIP fixes the project-side architecture and container setup; the final registry upload is still performed by Vercel.
