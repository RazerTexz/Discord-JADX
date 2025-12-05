package com.discord.widgets.guilds;

import android.content.Context;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long folderId;
    private StoreState previousStoreState;
    private final StoreUserSettings storeUserSettings;

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$1 */
    public static final class C85781 extends Lambda implements Function1<StoreState, Unit> {
        public C85781() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetGuildFolderSettingsViewModel.access$handleStoreState(WidgetGuildFolderSettingsViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
            return companion.observeStoreState(j, storeUserSettings, storeGuildsSorted);
        }

        private final Observable<StoreState> observeStoreState(long folderId, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
            Observable<StoreState> observableM11076j = Observable.m11076j(storeUserSettings.observeGuildFolders(), storeGuildsSorted.observeEntries(), new WidgetGuildFolderSettingsViewModel2(folderId));
            Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…Guilds)\n        }\n      }");
            return observableM11076j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class UpdateFolderSettingsFailure extends Event {
            private final int failureMessageStringRes;

            public UpdateFolderSettingsFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ UpdateFolderSettingsFailure copy$default(UpdateFolderSettingsFailure updateFolderSettingsFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updateFolderSettingsFailure.failureMessageStringRes;
                }
                return updateFolderSettingsFailure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final UpdateFolderSettingsFailure copy(int failureMessageStringRes) {
                return new UpdateFolderSettingsFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof UpdateFolderSettingsFailure) && this.failureMessageStringRes == ((UpdateFolderSettingsFailure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return outline.m814B(outline.m833U("UpdateFolderSettingsFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class UpdateFolderSettingsSuccess extends Event {
            private final int successMessageStringRes;

            public UpdateFolderSettingsSuccess(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ UpdateFolderSettingsSuccess copy$default(UpdateFolderSettingsSuccess updateFolderSettingsSuccess, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = updateFolderSettingsSuccess.successMessageStringRes;
                }
                return updateFolderSettingsSuccess.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final UpdateFolderSettingsSuccess copy(int successMessageStringRes) {
                return new UpdateFolderSettingsSuccess(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof UpdateFolderSettingsSuccess) && this.successMessageStringRes == ((UpdateFolderSettingsSuccess) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return outline.m814B(outline.m833U("UpdateFolderSettingsSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static final /* data */ class FormState {
        private final Integer color;
        private final String name;

        public FormState(String str, Integer num) {
            this.name = str;
            this.color = num;
        }

        public static /* synthetic */ FormState copy$default(FormState formState, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formState.name;
            }
            if ((i & 2) != 0) {
                num = formState.color;
            }
            return formState.copy(str, num);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getColor() {
            return this.color;
        }

        public final FormState copy(String name, Integer color) {
            return new FormState(name, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormState)) {
                return false;
            }
            FormState formState = (FormState) other;
            return Intrinsics3.areEqual(this.name, formState.name) && Intrinsics3.areEqual(this.color, formState.color);
        }

        public final Integer getColor() {
            return this.color;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.color;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("FormState(name=");
            sbM833U.append(this.name);
            sbM833U.append(", color=");
            return outline.m818F(sbM833U, this.color, ")");
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final ModelGuildFolder folder;
            private final List<StoreGuildsSorted.Entry> sortedGuilds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Valid(ModelGuildFolder modelGuildFolder, List<? extends StoreGuildsSorted.Entry> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildFolder, "folder");
                Intrinsics3.checkNotNullParameter(list, "sortedGuilds");
                this.folder = modelGuildFolder;
                this.sortedGuilds = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, ModelGuildFolder modelGuildFolder, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildFolder = valid.folder;
                }
                if ((i & 2) != 0) {
                    list = valid.sortedGuilds;
                }
                return valid.copy(modelGuildFolder, list);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final List<StoreGuildsSorted.Entry> component2() {
                return this.sortedGuilds;
            }

            public final Valid copy(ModelGuildFolder folder, List<? extends StoreGuildsSorted.Entry> sortedGuilds) {
                Intrinsics3.checkNotNullParameter(folder, "folder");
                Intrinsics3.checkNotNullParameter(sortedGuilds, "sortedGuilds");
                return new Valid(folder, sortedGuilds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.folder, valid.folder) && Intrinsics3.areEqual(this.sortedGuilds, valid.sortedGuilds);
            }

            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final List<StoreGuildsSorted.Entry> getSortedGuilds() {
                return this.sortedGuilds;
            }

            public int hashCode() {
                ModelGuildFolder modelGuildFolder = this.folder;
                int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
                List<StoreGuildsSorted.Entry> list = this.sortedGuilds;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Valid(folder=");
                sbM833U.append(this.folder);
                sbM833U.append(", sortedGuilds=");
                return outline.m824L(sbM833U, this.sortedGuilds, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final FormState formState;
            private final boolean showSave;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(FormState formState, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(formState, "formState");
                this.formState = formState;
                this.showSave = z2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, FormState formState, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    formState = loaded.formState;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showSave;
                }
                return loaded.copy(formState, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final FormState getFormState() {
                return this.formState;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowSave() {
                return this.showSave;
            }

            public final Loaded copy(FormState formState, boolean showSave) {
                Intrinsics3.checkNotNullParameter(formState, "formState");
                return new Loaded(formState, showSave);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.formState, loaded.formState) && this.showSave == loaded.showSave;
            }

            public final FormState getFormState() {
                return this.formState;
            }

            public final boolean getShowSave() {
                return this.showSave;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                FormState formState = this.formState;
                int iHashCode = (formState != null ? formState.hashCode() : 0) * 31;
                boolean z2 = this.showSave;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(formState=");
                sbM833U.append(this.formState);
                sbM833U.append(", showSave=");
                return outline.m827O(sbM833U, this.showSave, ")");
            }
        }

        /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$saveFolder$1 */
    public static final class C85791 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public C85791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
            WidgetGuildFolderSettingsViewModel.access$emitUpdateSuccessEvent(WidgetGuildFolderSettingsViewModel.this);
        }
    }

    /* compiled from: WidgetGuildFolderSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$saveFolder$2 */
    public static final class C85802 extends Lambda implements Function1<Error, Unit> {
        public C85802() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetGuildFolderSettingsViewModel.access$emitUpdateFailureEvent(WidgetGuildFolderSettingsViewModel.this);
        }
    }

    public /* synthetic */ WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 4) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted);
    }

    public static final /* synthetic */ void access$emitUpdateFailureEvent(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        widgetGuildFolderSettingsViewModel.emitUpdateFailureEvent();
    }

    public static final /* synthetic */ void access$emitUpdateSuccessEvent(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel) {
        widgetGuildFolderSettingsViewModel.emitUpdateSuccessEvent();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildFolderSettingsViewModel widgetGuildFolderSettingsViewModel, StoreState storeState) {
        widgetGuildFolderSettingsViewModel.handleStoreState(storeState);
    }

    private final void emitUpdateFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.UpdateFolderSettingsFailure(C5419R.string.default_failure_to_perform_action_message));
    }

    private final void emitUpdateSuccessEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.UpdateFolderSettingsSuccess(C5419R.string.guild_folder_updated_success));
    }

    private final void handleStoreState(StoreState storeState) {
        this.previousStoreState = storeState;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            FormState formState = new FormState(valid.getFolder().getName(), valid.getFolder().getColor());
            updateViewState(new ViewState.Loaded(formState, shouldShowSave(valid, formState)));
        }
    }

    private final boolean shouldShowSave(StoreState.Valid storeState, FormState formState) {
        return (Intrinsics3.areEqual(storeState.getFolder().getColor(), formState.getColor()) ^ true) || (Intrinsics3.areEqual(storeState.getFolder().getName(), formState.getName()) ^ true);
    }

    private final void updateFormState(FormState formState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreState storeState = this.previousStoreState;
            updateViewState(loaded.copy(formState, storeState instanceof StoreState.Valid ? shouldShowSave((StoreState.Valid) storeState, formState) : false));
        }
    }

    public final long getFolderId() {
        return this.folderId;
    }

    public final StoreState getPreviousStoreState() {
        return this.previousStoreState;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveFolder() {
        ModelGuildFolder modelGuildFolderAsModelGuildFolder;
        StoreState storeState = this.previousStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.Loaded)) {
                viewState = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewState;
            if (loaded != null) {
                FormState formState = loaded.getFormState();
                List<StoreGuildsSorted.Entry> sortedGuilds = valid.getSortedGuilds();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(sortedGuilds, 10));
                for (StoreGuildsSorted.Entry entry : sortedGuilds) {
                    if (entry instanceof StoreGuildsSorted.Entry.SingletonGuild) {
                        modelGuildFolderAsModelGuildFolder = entry.asModelGuildFolder();
                    } else {
                        if (!(entry instanceof StoreGuildsSorted.Entry.Folder)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        StoreGuildsSorted.Entry.Folder folder = (StoreGuildsSorted.Entry.Folder) entry;
                        modelGuildFolderAsModelGuildFolder = folder.getId() == this.folderId ? StoreGuildsSorted.Entry.Folder.copy$default(folder, 0L, null, formState.getColor(), formState.getName(), 3, null).asModelGuildFolder() : entry.asModelGuildFolder();
                    }
                    arrayList.add(modelGuildFolderAsModelGuildFolder);
                }
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithGuildFolders(arrayList)), false, 1, null), this, null, 2, null), WidgetGuildFolderSettingsViewModel.class, (Context) null, (Function1) null, new C85802(), (Function0) null, (Function0) null, new C85791(), 54, (Object) null);
            }
        }
    }

    public final void setColor(Integer color) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, color, 1, null));
        }
    }

    public final void setName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), name, null, 2, null));
        }
    }

    public final void setPreviousStoreState(StoreState storeState) {
        this.previousStoreState = storeState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettingsViewModel(long j, StoreUserSettings storeUserSettings, StoreGuildsSorted storeGuildsSorted) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        this.folderId = j;
        this.storeUserSettings = storeUserSettings;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Companion.access$observeStoreState(INSTANCE, j, storeUserSettings, storeGuildsSorted)), this, null, 2, null), WidgetGuildFolderSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85781(), 62, (Object) null);
        this.eventSubject = PublishSubject.m11133k0();
    }
}
