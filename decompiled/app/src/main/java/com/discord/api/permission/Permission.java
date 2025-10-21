package com.discord.api.permission;


/* compiled from: Permission.kt */
/* loaded from: classes.dex */
public final class Permission {
    public static final long ADD_REACTIONS = 64;
    public static final long ADMINISTRATOR = 8;
    public static final long ALL = 1649266917119L;
    public static final long ATTACH_FILES = 32768;
    public static final long BAN_MEMBERS = 4;
    public static final long CHANGE_NICKNAME = 67108864;
    public static final long CONNECT = 1048576;
    public static final long CREATE_INSTANT_INVITE = 1;
    public static final long CREATE_PRIVATE_THREADS = 68719476736L;
    public static final long CREATE_PUBLIC_THREADS = 34359738368L;
    public static final long DEAFEN_MEMBERS = 8388608;
    public static final long DEFAULT = 521942851137L;
    public static final long ELEVATED = 1125549875262L;
    public static final long EMBED_LINKS = 16384;
    public static final Permission INSTANCE = new Permission();
    public static final long KICK_MEMBERS = 2;
    public static final long MANAGEMENT_PERMISSIONS = 1110127411262L;
    public static final long MANAGE_CHANNELS = 16;
    public static final long MANAGE_EMOJIS_AND_STICKERS = 1073741824;
    public static final long MANAGE_EVENTS = 8589934592L;
    public static final long MANAGE_GUILD = 32;
    public static final long MANAGE_MESSAGES = 8192;
    public static final long MANAGE_NICKNAMES = 134217728;
    public static final long MANAGE_ROLES = 268435456;
    public static final long MANAGE_THREADS = 17179869184L;
    public static final long MANAGE_WEBHOOKS = 536870912;
    public static final long MENTION_EVERYONE = 131072;
    public static final long MODERATE_MEMBERS = 1099511627776L;
    public static final long MODERATE_STAGE_CHANNEL = 20971536;
    public static final long MODERATOR_PERMISSIONS = 1116960071742L;
    public static final long MOVE_MEMBERS = 16777216;
    public static final long MUTE_MEMBERS = 4194304;
    public static final long NONE = 0;
    public static final long PRIORITY_SPEAKER = 256;
    public static final long READ_MESSAGE_HISTORY = 65536;
    public static final long REQUEST_TO_SPEAK = 4294967296L;
    public static final long SEND_MESSAGES = 2048;
    public static final long SEND_MESSAGES_IN_THREADS = 274877906944L;
    public static final long SEND_TTS_MESSAGES = 4096;
    public static final long SPEAK = 2097152;
    public static final long START_STAGE_EVENT = 8610906128L;
    public static final long START_VOICE_EVENT = 8590984192L;
    public static final long STREAM = 512;
    public static final long USE_APPLICATION_COMMANDS = 2147483648L;
    public static final long USE_EXTERNAL_EMOJIS = 262144;
    public static final long USE_EXTERNAL_STICKERS = 137438953472L;
    public static final long USE_VAD = 33554432;
    public static final long VIEW_AUDIT_LOG = 128;
    public static final long VIEW_CHANNEL = 1024;
    public static final long VIEW_GUILD_ANALYTICS = 524288;

    /* compiled from: Permission.kt */
    public static final class AllowList {
        public static final long COMMUNICATIONS_DISABLED_DEFAULT = 66560;
        public static final AllowList INSTANCE = new AllowList();
        public static final long LURKER_DEFAULT = 66560;
        public static final long LURKER_STAGE_CHANNEL = 4331734016L;
    }
}
