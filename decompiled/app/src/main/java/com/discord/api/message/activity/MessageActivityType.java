package com.discord.api.message.activity;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageActivityType.kt */
/* loaded from: classes.dex */
public enum MessageActivityType {
    JOIN(1),
    SPECTATE(2),
    LISTEN(3),
    WATCH(4),
    REQUEST(5);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiInt;

    /* compiled from: MessageActivityType.kt */
    public static final class Companion {
        public Companion() {
        }

        public final MessageActivityType a(Integer num) {
            MessageActivityType messageActivityType = MessageActivityType.JOIN;
            int apiInt = messageActivityType.getApiInt();
            if (num != null && num.intValue() == apiInt) {
                return messageActivityType;
            }
            MessageActivityType messageActivityType2 = MessageActivityType.SPECTATE;
            int apiInt2 = messageActivityType2.getApiInt();
            if (num == null || num.intValue() != apiInt2) {
                messageActivityType2 = MessageActivityType.LISTEN;
                int apiInt3 = messageActivityType2.getApiInt();
                if (num == null || num.intValue() != apiInt3) {
                    messageActivityType2 = MessageActivityType.WATCH;
                    int apiInt4 = messageActivityType2.getApiInt();
                    if (num == null || num.intValue() != apiInt4) {
                        messageActivityType2 = MessageActivityType.REQUEST;
                        int apiInt5 = messageActivityType2.getApiInt();
                        if (num == null || num.intValue() != apiInt5) {
                            return messageActivityType;
                        }
                    }
                }
            }
            return messageActivityType2;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    MessageActivityType(int i) {
        this.apiInt = i;
    }

    public final int getApiInt() {
        return this.apiInt;
    }
}
