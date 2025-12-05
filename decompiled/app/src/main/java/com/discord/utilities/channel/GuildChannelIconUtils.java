package com.discord.utilities.channel;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildChannelIconUtils.kt */
/* renamed from: com.discord.utilities.channel.GuildChannelIconType, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class GuildChannelIconUtils {

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Announcements */
    public static final class Announcements extends GuildChannelIconUtils {
        public static final Announcements INSTANCE = new Announcements();

        private Announcements() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Directory */
    public static final class Directory extends GuildChannelIconUtils {
        public static final Directory INSTANCE = new Directory();

        private Directory() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Forum */
    public static final class Forum extends GuildChannelIconUtils {
        public static final Forum INSTANCE = new Forum();

        private Forum() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$ForumPost */
    public static final class ForumPost extends GuildChannelIconUtils {
        public static final ForumPost INSTANCE = new ForumPost();

        private ForumPost() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked */
    public static abstract class Locked {

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Announcements */
        public static final class Announcements extends GuildChannelIconUtils {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Forum */
        public static final class Forum extends GuildChannelIconUtils {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$ForumPost */
        public static final class ForumPost extends GuildChannelIconUtils {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Text */
        public static final class Text extends GuildChannelIconUtils {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Thread */
        public static final class Thread extends GuildChannelIconUtils {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        private Locked() {
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW */
    public static abstract class NSFW {

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Announcements */
        public static final class Announcements extends GuildChannelIconUtils {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Forum */
        public static final class Forum extends GuildChannelIconUtils {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$ForumPost */
        public static final class ForumPost extends GuildChannelIconUtils {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Text */
        public static final class Text extends GuildChannelIconUtils {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Thread */
        public static final class Thread extends GuildChannelIconUtils {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        /* compiled from: GuildChannelIconUtils.kt */
        /* renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Voice */
        public static final class Voice extends GuildChannelIconUtils {
            public static final Voice INSTANCE = new Voice();

            private Voice() {
                super(null);
            }
        }

        private NSFW() {
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Text */
    public static final class Text extends GuildChannelIconUtils {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Thread */
    public static final class Thread extends GuildChannelIconUtils {
        public static final Thread INSTANCE = new Thread();

        private Thread() {
            super(null);
        }
    }

    /* compiled from: GuildChannelIconUtils.kt */
    /* renamed from: com.discord.utilities.channel.GuildChannelIconType$Voice */
    public static final class Voice extends GuildChannelIconUtils {
        public static final Voice INSTANCE = new Voice();

        private Voice() {
            super(null);
        }
    }

    private GuildChannelIconUtils() {
    }

    public /* synthetic */ GuildChannelIconUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
