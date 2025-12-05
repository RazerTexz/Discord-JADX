package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubWaitlistViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetHubWaitlistViewModel extends AppViewModel<WidgetHubWaitlistViewModel3> {
    private final String email;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubWaitlistViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlistViewModel$joinWaitlist$1 */
    public static final class C90471 extends Lambda implements Function1<RestCallState<? extends WaitlistSignup>, Unit> {
        public C90471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends WaitlistSignup> restCallState) {
            invoke2((RestCallState<WaitlistSignup>) restCallState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<WaitlistSignup> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "async");
            WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3Access$getViewState$p = WidgetHubWaitlistViewModel.access$getViewState$p(WidgetHubWaitlistViewModel.this);
            if (widgetHubWaitlistViewModel3Access$getViewState$p != null) {
                WidgetHubWaitlistViewModel.access$updateViewState(WidgetHubWaitlistViewModel.this, widgetHubWaitlistViewModel3Access$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ WidgetHubWaitlistViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ WidgetHubWaitlistViewModel3 access$getViewState$p(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel) {
        return widgetHubWaitlistViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel, WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
        widgetHubWaitlistViewModel.updateViewState(widgetHubWaitlistViewModel3);
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinWaitlist(String school) {
        Intrinsics3.checkNotNullParameter(school, "school");
        RestCallState5.executeRequest(this.restAPI.joinHubWaitlist(new RestAPIParams.HubWaitlist(this.email, school)), new C90471());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlistViewModel(String str, RestAPI restAPI) {
        super(new WidgetHubWaitlistViewModel3(null, 1, null));
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.restAPI = restAPI;
    }
}
