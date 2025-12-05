package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import com.discord.api.application.Application;
import com.discord.api.application.ApplicationType;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
/* loaded from: classes2.dex */
public final class ServerSettingsEmptyGuildRoleSubscriptionsViewModel extends AppViewModel<ViewState> {
    private final long guildId;

    /* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel$1 */
    public static final class C94391 extends Lambda implements Function1<List<? extends Application>, Unit> {
        public C94391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
            invoke2((List<Application>) list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Application> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$handleMonetizationStatus(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.this, list);
        }
    }

    /* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel$2 */
    public static final class C94402 extends Lambda implements Function1<Error, Unit> {
        public C94402() {
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
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel = ServerSettingsEmptyGuildRoleSubscriptionsViewModel.this;
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$updateViewState(serverSettingsEmptyGuildRoleSubscriptionsViewModel, ViewState.copy$default(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$requireViewState(serverSettingsEmptyGuildRoleSubscriptionsViewModel), false, null, 2, null));
        }
    }

    /* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Boolean isMonetizationEnabled;

        public ViewState() {
            this(false, null, 3, null);
        }

        public ViewState(boolean z2, Boolean bool) {
            this.isLoading = z2;
            this.isMonetizationEnabled = bool;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isLoading;
            }
            if ((i & 2) != 0) {
                bool = viewState.isMonetizationEnabled;
            }
            return viewState.copy(z2, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getIsMonetizationEnabled() {
            return this.isMonetizationEnabled;
        }

        public final ViewState copy(boolean isLoading, Boolean isMonetizationEnabled) {
            return new ViewState(isLoading, isMonetizationEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics3.areEqual(this.isMonetizationEnabled, viewState.isMonetizationEnabled);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Boolean bool = this.isMonetizationEnabled;
            return i + (bool != null ? bool.hashCode() : 0);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final Boolean isMonetizationEnabled() {
            return this.isMonetizationEnabled;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ViewState(isLoading=");
            sbM833U.append(this.isLoading);
            sbM833U.append(", isMonetizationEnabled=");
            return outline.m816D(sbM833U, this.isMonetizationEnabled, ")");
        }

        public /* synthetic */ ViewState(boolean z2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z2, (i & 2) != 0 ? null : bool);
        }
    }

    public /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$handleMonetizationStatus(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel, List list) {
        serverSettingsEmptyGuildRoleSubscriptionsViewModel.handleMonetizationStatus(list);
    }

    public static final /* synthetic */ ViewState access$requireViewState(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel) {
        return serverSettingsEmptyGuildRoleSubscriptionsViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel, ViewState viewState) {
        serverSettingsEmptyGuildRoleSubscriptionsViewModel.updateViewState(viewState);
    }

    private final void handleMonetizationStatus(List<Application> applications) {
        Object next;
        Iterator<T> it = applications.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Application application = (Application) next;
            Long guildId = application.getGuildId();
            if (guildId != null && guildId.longValue() == this.guildId && application.getType() == ApplicationType.GUILD_ROLE_SUBSCRIPTIONS) {
                break;
            }
        }
        updateViewState(requireViewState().copy(false, Boolean.valueOf(((Application) next) != null)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI) {
        super(new ViewState(false, null, 3, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.getGuildApplications(j, false), false, 1, null), this, null, 2, null), ServerSettingsEmptyGuildRoleSubscriptionsViewModel.class, (Context) null, (Function1) null, new C94402(), (Function0) null, (Function0) null, new C94391(), 54, (Object) null);
    }
}
