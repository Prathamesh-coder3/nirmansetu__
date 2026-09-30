@echo off
setlocal
set "ROOT=%~dp0"
title NirmaanSetu - Local Full Stack

echo ================================================
echo        NirmaanSetu - Local Full Stack
echo ================================================
echo.
echo Starting Spring Boot backend on port 8080...
start "NirmaanSetu Backend" cmd /k "cd /d "%ROOT%backend" ^&^& mvn spring-boot:run"

echo Starting React/Vite frontend on port 5173...
if not exist "%ROOT%frontend\node_modules" (
  start "NirmaanSetu Frontend Install" cmd /k "cd /d "%ROOT%frontend" ^&^& npm install ^&^& npm run dev"
) else (
  start "NirmaanSetu Frontend" cmd /k "cd /d "%ROOT%frontend" ^&^& npm run dev"
)

timeout /t 5 /nobreak >nul
start "" "http://localhost:5173/"
endlocal
