# LiteBansNotifyVelocity

Velocity plugin for sending LiteBans punishment notifications to a Telegram topic (thread).

## Requirements

- Java 21+
- Velocity `3.4.0-SNAPSHOT` (or compatible versions)
- LiteBans installed on the same proxy process (API class `litebans.api.Events` must be present)

## Build

```bash
mvn clean package
```

Output jar: `target/LiteBansNotifyVelocity-1.0.jar`

## Install

1. Put the jar into Velocity `plugins` directory.
2. Start proxy once to generate `plugins/litebansnotifyvelocity/config.yml`.
3. Fill config values:

```yaml
telegram:
  token: "123456:ABCDEF..."
  chatId: -1001234567890
  threadId: 12
format:
  datePattern: "dd.MM.yy HH:mm"
  messageTemplate: "{type}\\n--------------------\\nНик: {playerName}\\nUUID: {playerId}\\nНаказал: {executor}\\nДата: {date}\\nДлительность: {until}\\nПричина: {reason}\\nРежим: {scope}"
```

4. Restart proxy.

## Placeholders in `messageTemplate`

- `{type}` - punishment type with emoji (for example `🔇 МУТ`)
- `{player}` - punished player in combined view (`nick (uuid)` when both are available)
- `{playerName}` - punished player nickname
- `{playerId}` - punished player UUID / id
- `{executor}` - who punished
- `{date}` - punishment start date
- `{until}` - expiration date or `Навсегда`
- `{reason}` - reason
- `{scope}` - LiteBans scope (`global` and so on)

## Notes

- This plugin sends only Telegram messages.
- Notifications are sent for added entries (`ban`, `mute`, `kick`, `warn`).
- Existing `config.yml` is not rewritten automatically. To use the new separate lines immediately, update `format.messageTemplate` manually.
