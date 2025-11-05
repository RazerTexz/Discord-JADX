package com.discord.widgets.nux;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildTemplatesAdapter.kt */
/* loaded from: classes2.dex */
public abstract class GuildTemplateViewType {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TEMPLATE = 1;
    private static final int TEXT = 0;
    private final int viewType;

    /* compiled from: GuildTemplatesAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int getTEMPLATE() {
            return GuildTemplateViewType.access$getTEMPLATE$cp();
        }

        public final int getTEXT() {
            return GuildTemplateViewType.access$getTEXT$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildTemplatesAdapter.kt */
    public static final /* data */ class Template extends GuildTemplateViewType {
        private final GuildTemplate guildTemplate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Template(GuildTemplate guildTemplate) {
            super(GuildTemplateViewType.INSTANCE.getTEMPLATE(), null);
            m.checkNotNullParameter(guildTemplate, "guildTemplate");
            this.guildTemplate = guildTemplate;
        }

        public static /* synthetic */ Template copy$default(Template template, GuildTemplate guildTemplate, int i, Object obj) {
            if ((i & 1) != 0) {
                guildTemplate = template.guildTemplate;
            }
            return template.copy(guildTemplate);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildTemplate getGuildTemplate() {
            return this.guildTemplate;
        }

        public final Template copy(GuildTemplate guildTemplate) {
            m.checkNotNullParameter(guildTemplate, "guildTemplate");
            return new Template(guildTemplate);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Template) && m.areEqual(this.guildTemplate, ((Template) other).guildTemplate);
            }
            return true;
        }

        public final GuildTemplate getGuildTemplate() {
            return this.guildTemplate;
        }

        public int hashCode() {
            GuildTemplate guildTemplate = this.guildTemplate;
            if (guildTemplate != null) {
                return guildTemplate.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("Template(guildTemplate=");
            sbU.append(this.guildTemplate);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildTemplatesAdapter.kt */
    public static final class Text extends GuildTemplateViewType {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(GuildTemplateViewType.INSTANCE.getTEXT(), null);
        }
    }

    private GuildTemplateViewType(int i) {
        this.viewType = i;
    }

    public static final /* synthetic */ int access$getTEMPLATE$cp() {
        return TEMPLATE;
    }

    public static final /* synthetic */ int access$getTEXT$cp() {
        return TEXT;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ GuildTemplateViewType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
