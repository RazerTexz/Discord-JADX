package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.g;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public final /* data */ class GlobalRoleAutocompletable extends Autocompletable {
    private final String text;
    private final List<String> textMatchers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy here$delegate = g.lazy(GlobalRoleAutocompletable$Companion$here$2.INSTANCE);
    private static final Lazy everyone$delegate = g.lazy(GlobalRoleAutocompletable$Companion$everyone$2.INSTANCE);

    /* compiled from: Autocompletable.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GlobalRoleAutocompletable getEveryone() {
            Lazy lazyAccess$getEveryone$cp = GlobalRoleAutocompletable.access$getEveryone$cp();
            Companion companion = GlobalRoleAutocompletable.INSTANCE;
            return (GlobalRoleAutocompletable) lazyAccess$getEveryone$cp.getValue();
        }

        public final GlobalRoleAutocompletable getHere() {
            Lazy lazyAccess$getHere$cp = GlobalRoleAutocompletable.access$getHere$cp();
            Companion companion = GlobalRoleAutocompletable.INSTANCE;
            return (GlobalRoleAutocompletable) lazyAccess$getHere$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalRoleAutocompletable(String str) {
        super(null);
        m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.text = str;
        this.textMatchers = d0.t.m.listOf(leadingIdentifier().getIdentifier() + str);
    }

    public static final /* synthetic */ Lazy access$getEveryone$cp() {
        return everyone$delegate;
    }

    public static final /* synthetic */ Lazy access$getHere$cp() {
        return here$delegate;
    }

    public static /* synthetic */ GlobalRoleAutocompletable copy$default(GlobalRoleAutocompletable globalRoleAutocompletable, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = globalRoleAutocompletable.text;
        }
        return globalRoleAutocompletable.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final GlobalRoleAutocompletable copy(String text) {
        m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new GlobalRoleAutocompletable(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GlobalRoleAutocompletable) && m.areEqual(this.text, ((GlobalRoleAutocompletable) other).text);
        }
        return true;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return leadingIdentifier().getIdentifier() + this.text;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getText() {
        return this.text;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        return a.J(a.U("GlobalRoleAutocompletable(text="), this.text, ")");
    }
}
