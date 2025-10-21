package com.discord.widgets.nux;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildTemplatesAdapter.kt */
/* renamed from: com.discord.widgets.nux.GuildTemplateViewType, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class GuildTemplatesAdapter2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TEMPLATE = 1;
    private static final int TEXT = 0;
    private final int viewType;

    /* compiled from: GuildTemplatesAdapter.kt */
    /* renamed from: com.discord.widgets.nux.GuildTemplateViewType$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final int getTEMPLATE() {
            return GuildTemplatesAdapter2.access$getTEMPLATE$cp();
        }

        public final int getTEXT() {
            return GuildTemplatesAdapter2.access$getTEXT$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildTemplatesAdapter.kt */
    /* renamed from: com.discord.widgets.nux.GuildTemplateViewType$Template */
    public static final /* data */ class Template extends GuildTemplatesAdapter2 {
        private final GuildTemplates guildTemplate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Template(GuildTemplates guildTemplates) {
            super(GuildTemplatesAdapter2.INSTANCE.getTEMPLATE(), null);
            Intrinsics3.checkNotNullParameter(guildTemplates, "guildTemplate");
            this.guildTemplate = guildTemplates;
        }

        public static /* synthetic */ Template copy$default(Template template, GuildTemplates guildTemplates, int i, Object obj) {
            if ((i & 1) != 0) {
                guildTemplates = template.guildTemplate;
            }
            return template.copy(guildTemplates);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildTemplates getGuildTemplate() {
            return this.guildTemplate;
        }

        public final Template copy(GuildTemplates guildTemplate) {
            Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
            return new Template(guildTemplate);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Template) && Intrinsics3.areEqual(this.guildTemplate, ((Template) other).guildTemplate);
            }
            return true;
        }

        public final GuildTemplates getGuildTemplate() {
            return this.guildTemplate;
        }

        public int hashCode() {
            GuildTemplates guildTemplates = this.guildTemplate;
            if (guildTemplates != null) {
                return guildTemplates.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Template(guildTemplate=");
            sbU.append(this.guildTemplate);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildTemplatesAdapter.kt */
    /* renamed from: com.discord.widgets.nux.GuildTemplateViewType$Text */
    public static final class Text extends GuildTemplatesAdapter2 {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(GuildTemplatesAdapter2.INSTANCE.getTEXT(), null);
        }
    }

    private GuildTemplatesAdapter2(int i) {
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

    public /* synthetic */ GuildTemplatesAdapter2(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
