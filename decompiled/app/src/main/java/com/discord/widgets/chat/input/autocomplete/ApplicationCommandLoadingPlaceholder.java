package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.Application;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public final /* data */ class ApplicationCommandLoadingPlaceholder extends Autocompletable {
    private final Application application;

    public ApplicationCommandLoadingPlaceholder() {
        this(null, 1, null);
    }

    public /* synthetic */ ApplicationCommandLoadingPlaceholder(Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : application);
    }

    public static /* synthetic */ ApplicationCommandLoadingPlaceholder copy$default(ApplicationCommandLoadingPlaceholder applicationCommandLoadingPlaceholder, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationCommandLoadingPlaceholder.application;
        }
        return applicationCommandLoadingPlaceholder.copy(application);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommandLoadingPlaceholder copy(Application application) {
        return new ApplicationCommandLoadingPlaceholder(application);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ApplicationCommandLoadingPlaceholder) && Intrinsics3.areEqual(this.application, ((ApplicationCommandLoadingPlaceholder) other).application);
        }
        return true;
    }

    public final Application getApplication() {
        return this.application;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return "";
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return Collections2.emptyList();
    }

    public int hashCode() {
        Application application = this.application;
        if (application != null) {
            return application.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApplicationCommandLoadingPlaceholder(application=");
        sbM833U.append(this.application);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public ApplicationCommandLoadingPlaceholder(Application application) {
        super(null);
        this.application = application;
    }
}
