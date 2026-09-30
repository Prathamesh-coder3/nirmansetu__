# NirmaanSetu

NirmaanSetu is a full-stack workforce skilling and employment platform.

## Vercel architecture

This repository is a monorepo:

```text
NirmaanSetu/
├── vercel.json
├── frontend/   # React + Vite service
└── backend/    # Java 21 + Spring Boot container service
```

One GitHub repository and one Vercel project are used.

Routing:

```text
/api/*  -> api service -> Spring Boot
/*      -> frontend service -> React/Vite
```

The backend entry point is:

`backend/src/main/java/com/nirmaansetu/NirmaanSetuApplication.java`

The Vercel backend container entry point is:

`backend/Dockerfile.vercel`

## Vercel Services architecture

This repository is designed for **one GitHub repository + one Vercel project** using Vercel Services.

```text
NirmaanSetu/
├── vercel.json
├── frontend/     -> Vite
└── backend/      -> Java 21 + Spring Boot container
```

Use a clean Vercel project name such as `nirmaansetu`. Do not deploy into a project whose name produces an invalid container reference such as `nirmansetu../api`.
