package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public final /* data */ class ApplicationPlaceholder extends Autocompletable {
    private final Application application;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationPlaceholder(Application application) {
        super(null);
        Intrinsics3.checkNotNullParameter(application, "application");
        this.application = application;
    }

    public static /* synthetic */ ApplicationPlaceholder copy$default(ApplicationPlaceholder applicationPlaceholder, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationPlaceholder.application;
        }
        return applicationPlaceholder.copy(application);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationPlaceholder copy(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        return new ApplicationPlaceholder(application);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ApplicationPlaceholder) && Intrinsics3.areEqual(this.application, ((ApplicationPlaceholder) other).application);
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
        StringBuilder sbU = outline.U("ApplicationPlaceholder(application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }
}
