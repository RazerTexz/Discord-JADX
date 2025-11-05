package com.discord.widgets.guilds.create;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StockGuildTemplate.kt */
/* loaded from: classes2.dex */
public abstract class ChannelTemplate {
    private final Long id;
    private final String name;

    /* compiled from: StockGuildTemplate.kt */
    public static final class NormalChannel extends ChannelTemplate {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalChannel(String str) {
            super(null, str, null);
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    /* compiled from: StockGuildTemplate.kt */
    public static final class SystemChannel extends ChannelTemplate {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SystemChannel(String str) {
            super(11L, str, null);
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        }
    }

    private ChannelTemplate(Long l, String str) {
        this.id = l;
        this.name = str;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ ChannelTemplate(Long l, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str);
    }
}
