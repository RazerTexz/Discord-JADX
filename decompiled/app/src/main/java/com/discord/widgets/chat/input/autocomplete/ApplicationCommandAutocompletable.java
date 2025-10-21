package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public final /* data */ class ApplicationCommandAutocompletable extends Autocompletable {
    private final Application application;
    private final ApplicationCommand command;
    private final boolean hasPermissionToUse;
    private final boolean showAvatar;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandAutocompletable(Application application, ApplicationCommand applicationCommand, boolean z2, boolean z3) {
        super(null);
        Intrinsics3.checkNotNullParameter(applicationCommand, "command");
        this.application = application;
        this.command = applicationCommand;
        this.hasPermissionToUse = z2;
        this.showAvatar = z3;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + applicationCommand.getName());
    }

    public static /* synthetic */ ApplicationCommandAutocompletable copy$default(ApplicationCommandAutocompletable applicationCommandAutocompletable, Application application, ApplicationCommand applicationCommand, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            application = applicationCommandAutocompletable.application;
        }
        if ((i & 2) != 0) {
            applicationCommand = applicationCommandAutocompletable.command;
        }
        if ((i & 4) != 0) {
            z2 = applicationCommandAutocompletable.hasPermissionToUse;
        }
        if ((i & 8) != 0) {
            z3 = applicationCommandAutocompletable.showAvatar;
        }
        return applicationCommandAutocompletable.copy(application, applicationCommand, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final ApplicationCommand getCommand() {
        return this.command;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasPermissionToUse() {
        return this.hasPermissionToUse;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final ApplicationCommandAutocompletable copy(Application application, ApplicationCommand command, boolean hasPermissionToUse, boolean showAvatar) {
        Intrinsics3.checkNotNullParameter(command, "command");
        return new ApplicationCommandAutocompletable(application, command, hasPermissionToUse, showAvatar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandAutocompletable)) {
            return false;
        }
        ApplicationCommandAutocompletable applicationCommandAutocompletable = (ApplicationCommandAutocompletable) other;
        return Intrinsics3.areEqual(this.application, applicationCommandAutocompletable.application) && Intrinsics3.areEqual(this.command, applicationCommandAutocompletable.command) && this.hasPermissionToUse == applicationCommandAutocompletable.hasPermissionToUse && this.showAvatar == applicationCommandAutocompletable.showAvatar;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommand getCommand() {
        return this.command;
    }

    public final boolean getHasPermissionToUse() {
        return this.hasPermissionToUse;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return leadingIdentifier().getIdentifier() + this.command.getName();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        ApplicationCommand applicationCommand = this.command;
        int iHashCode2 = (iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0)) * 31;
        boolean z2 = this.hasPermissionToUse;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.showAvatar;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.APP_COMMAND;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandAutocompletable(application=");
        sbU.append(this.application);
        sbU.append(", command=");
        sbU.append(this.command);
        sbU.append(", hasPermissionToUse=");
        sbU.append(this.hasPermissionToUse);
        sbU.append(", showAvatar=");
        return outline.O(sbU, this.showAvatar, ")");
    }
}
