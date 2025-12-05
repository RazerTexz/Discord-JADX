package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.widgets.chat.input.WidgetChatInputAutocompleteStickerAdapter2;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AutocompleteViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class AutocompleteViewModel4 {

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$Autocomplete */
    public static final /* data */ class Autocomplete extends AutocompleteViewModel4 {
        private final List<Autocompletable> autocompletables;
        private final boolean isAutocomplete;
        private final boolean isError;
        private final boolean isLoading;
        private final List<WidgetChatInputAutocompleteStickerAdapter2> stickers;
        private final String token;

        public /* synthetic */ Autocomplete(boolean z2, boolean z3, boolean z4, List list, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, list, list2, str);
        }

        public static /* synthetic */ Autocomplete copy$default(Autocomplete autocomplete, boolean z2, boolean z3, boolean z4, List list, List list2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = autocomplete.isLoading;
            }
            if ((i & 2) != 0) {
                z3 = autocomplete.isError;
            }
            boolean z5 = z3;
            if ((i & 4) != 0) {
                z4 = autocomplete.isAutocomplete;
            }
            boolean z6 = z4;
            if ((i & 8) != 0) {
                list = autocomplete.autocompletables;
            }
            List list3 = list;
            if ((i & 16) != 0) {
                list2 = autocomplete.stickers;
            }
            List list4 = list2;
            if ((i & 32) != 0) {
                str = autocomplete.token;
            }
            return autocomplete.copy(z2, z5, z6, list3, list4, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsError() {
            return this.isError;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsAutocomplete() {
            return this.isAutocomplete;
        }

        public final List<Autocompletable> component4() {
            return this.autocompletables;
        }

        public final List<WidgetChatInputAutocompleteStickerAdapter2> component5() {
            return this.stickers;
        }

        /* renamed from: component6, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public final Autocomplete copy(boolean isLoading, boolean isError, boolean isAutocomplete, List<? extends Autocompletable> autocompletables, List<WidgetChatInputAutocompleteStickerAdapter2> stickers, String token) {
            Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
            Intrinsics3.checkNotNullParameter(stickers, "stickers");
            Intrinsics3.checkNotNullParameter(token, "token");
            return new Autocomplete(isLoading, isError, isAutocomplete, autocompletables, stickers, token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Autocomplete)) {
                return false;
            }
            Autocomplete autocomplete = (Autocomplete) other;
            return this.isLoading == autocomplete.isLoading && this.isError == autocomplete.isError && this.isAutocomplete == autocomplete.isAutocomplete && Intrinsics3.areEqual(this.autocompletables, autocomplete.autocompletables) && Intrinsics3.areEqual(this.stickers, autocomplete.stickers) && Intrinsics3.areEqual(this.token, autocomplete.token);
        }

        public final List<Autocompletable> getAutocompletables() {
            return this.autocompletables;
        }

        public final List<WidgetChatInputAutocompleteStickerAdapter2> getStickers() {
            return this.stickers;
        }

        public final String getToken() {
            return this.token;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isError;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.isAutocomplete;
            int i4 = (i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            List<Autocompletable> list = this.autocompletables;
            int iHashCode = (i4 + (list != null ? list.hashCode() : 0)) * 31;
            List<WidgetChatInputAutocompleteStickerAdapter2> list2 = this.stickers;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            String str = this.token;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public final boolean isAutocomplete() {
            return this.isAutocomplete;
        }

        public final boolean isError() {
            return this.isError;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Autocomplete(isLoading=");
            sbM833U.append(this.isLoading);
            sbM833U.append(", isError=");
            sbM833U.append(this.isError);
            sbM833U.append(", isAutocomplete=");
            sbM833U.append(this.isAutocomplete);
            sbM833U.append(", autocompletables=");
            sbM833U.append(this.autocompletables);
            sbM833U.append(", stickers=");
            sbM833U.append(this.stickers);
            sbM833U.append(", token=");
            return outline.m822J(sbM833U, this.token, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Autocomplete(boolean z2, boolean z3, boolean z4, List<? extends Autocompletable> list, List<WidgetChatInputAutocompleteStickerAdapter2> list2, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "autocompletables");
            Intrinsics3.checkNotNullParameter(list2, "stickers");
            Intrinsics3.checkNotNullParameter(str, "token");
            this.isLoading = z2;
            this.isError = z3;
            this.isAutocomplete = z4;
            this.autocompletables = list;
            this.stickers = list2;
            this.token = str;
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$CommandBrowser */
    public static final /* data */ class CommandBrowser extends AutocompleteViewModel4 {
        private final List<Application> applications;
        private final WidgetChatInputDiscoveryCommandsModel discoverCommands;
        private final List<ApplicationCommand> frequentCommands;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CommandBrowser(List<? extends ApplicationCommand> list, List<Application> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "frequentCommands");
            Intrinsics3.checkNotNullParameter(list2, "applications");
            Intrinsics3.checkNotNullParameter(widgetChatInputDiscoveryCommandsModel, "discoverCommands");
            this.frequentCommands = list;
            this.applications = list2;
            this.discoverCommands = widgetChatInputDiscoveryCommandsModel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CommandBrowser copy$default(CommandBrowser commandBrowser, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, Object obj) {
            if ((i & 1) != 0) {
                list = commandBrowser.frequentCommands;
            }
            if ((i & 2) != 0) {
                list2 = commandBrowser.applications;
            }
            if ((i & 4) != 0) {
                widgetChatInputDiscoveryCommandsModel = commandBrowser.discoverCommands;
            }
            return commandBrowser.copy(list, list2, widgetChatInputDiscoveryCommandsModel);
        }

        public final List<ApplicationCommand> component1() {
            return this.frequentCommands;
        }

        public final List<Application> component2() {
            return this.applications;
        }

        /* renamed from: component3, reason: from getter */
        public final WidgetChatInputDiscoveryCommandsModel getDiscoverCommands() {
            return this.discoverCommands;
        }

        public final CommandBrowser copy(List<? extends ApplicationCommand> frequentCommands, List<Application> applications, WidgetChatInputDiscoveryCommandsModel discoverCommands) {
            Intrinsics3.checkNotNullParameter(frequentCommands, "frequentCommands");
            Intrinsics3.checkNotNullParameter(applications, "applications");
            Intrinsics3.checkNotNullParameter(discoverCommands, "discoverCommands");
            return new CommandBrowser(frequentCommands, applications, discoverCommands);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommandBrowser)) {
                return false;
            }
            CommandBrowser commandBrowser = (CommandBrowser) other;
            return Intrinsics3.areEqual(this.frequentCommands, commandBrowser.frequentCommands) && Intrinsics3.areEqual(this.applications, commandBrowser.applications) && Intrinsics3.areEqual(this.discoverCommands, commandBrowser.discoverCommands);
        }

        public final List<Application> getApplications() {
            return this.applications;
        }

        public final WidgetChatInputDiscoveryCommandsModel getDiscoverCommands() {
            return this.discoverCommands;
        }

        public final List<ApplicationCommand> getFrequentCommands() {
            return this.frequentCommands;
        }

        public int hashCode() {
            List<ApplicationCommand> list = this.frequentCommands;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<Application> list2 = this.applications;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.discoverCommands;
            return iHashCode2 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("CommandBrowser(frequentCommands=");
            sbM833U.append(this.frequentCommands);
            sbM833U.append(", applications=");
            sbM833U.append(this.applications);
            sbM833U.append(", discoverCommands=");
            sbM833U.append(this.discoverCommands);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$Hidden */
    public static final class Hidden extends AutocompleteViewModel4 {
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super(null);
        }
    }

    /* compiled from: AutocompleteViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewState$LoadingItems */
    public static final /* data */ class LoadingItems extends AutocompleteViewModel4 {
        private final int numberLoadingItems;

        public LoadingItems(int i) {
            super(null);
            this.numberLoadingItems = i;
        }

        public static /* synthetic */ LoadingItems copy$default(LoadingItems loadingItems, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadingItems.numberLoadingItems;
            }
            return loadingItems.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getNumberLoadingItems() {
            return this.numberLoadingItems;
        }

        public final LoadingItems copy(int numberLoadingItems) {
            return new LoadingItems(numberLoadingItems);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof LoadingItems) && this.numberLoadingItems == ((LoadingItems) other).numberLoadingItems;
            }
            return true;
        }

        public final int getNumberLoadingItems() {
            return this.numberLoadingItems;
        }

        public int hashCode() {
            return this.numberLoadingItems;
        }

        public String toString() {
            return outline.m814B(outline.m833U("LoadingItems(numberLoadingItems="), this.numberLoadingItems, ")");
        }
    }

    private AutocompleteViewModel4() {
    }

    public /* synthetic */ AutocompleteViewModel4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
