# TikTok Downloader Telegram Bot

This bot allows you to download videos from the TikTok social network (with 95% probability without a watermark) and 
send to Telegram bot.

The bot is based on [youtube4kdownloader.com](https://youtube4kdownloader.com/)

## Installation

1. Download and install [ngrok](https://ngrok.com/download).
2. Download and install [maven](https://maven.apache.org/).
3. Create your Telegram [bot](https://telegram.me/BotFather).
4. Clone this repository to any folder on your computer.

## Usage

1. Open ngrok.exe and write the command:

```bash
ngrok http 5000
```
2. Copy URL with https from Forwarding line

```text
Forwarding http://27fs-299-323-0-285.ngrok.io                    
Forwarding [this URL] -> https://27fs-299-323-0-285.ngrok.io <- [this URL]  
```

3. Copy the token of your telegram bot from bot father.
4. Paste the required parameters into the link and open it in a browser:

```text
https://api.telegram.org/bot[BOT_TOKEN]/setWebhook?url=[URL_FROM_OPTION_2]
```
If everything is correct, you will see the message:
```text
{"ok":true,"result":true,"description":"Webhook was set"}
```
5. Go to the folder with this repository.
6. Open a Windows/Bash command prompt and write the command:

```bash
./mvnw spring-boot:run "-DBOT_TOKEN=[YOUR_TELEGRAM_BOT_TOKEN]" "-DWEB_HOOK_PATH=[URL_FROM_FROM_OPTION_2]"
```
7. Go to the boot and send a message with a link to the TikTok video you want to download.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
