package com.discord.widgets.channels.permissions;

import b.a.d.d0;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModel extends d0<ViewState> {
    private final long channelId;

    /* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
    public enum Tab {
        MODERATOR,
        ADVANCED
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<Tab> availableTabs;
        private final Tab selectedTab;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(Tab tab, List<? extends Tab> list) {
            m.checkNotNullParameter(tab, "selectedTab");
            m.checkNotNullParameter(list, "availableTabs");
            this.selectedTab = tab;
            this.availableTabs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, Tab tab, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                tab = viewState.selectedTab;
            }
            if ((i & 2) != 0) {
                list = viewState.availableTabs;
            }
            return viewState.copy(tab, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Tab getSelectedTab() {
            return this.selectedTab;
        }

        public final List<Tab> component2() {
            return this.availableTabs;
        }

        public final ViewState copy(Tab selectedTab, List<? extends Tab> availableTabs) {
            m.checkNotNullParameter(selectedTab, "selectedTab");
            m.checkNotNullParameter(availableTabs, "availableTabs");
            return new ViewState(selectedTab, availableTabs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.selectedTab, viewState.selectedTab) && m.areEqual(this.availableTabs, viewState.availableTabs);
        }

        public final List<Tab> getAvailableTabs() {
            return this.availableTabs;
        }

        public final Tab getSelectedTab() {
            return this.selectedTab;
        }

        public int hashCode() {
            Tab tab = this.selectedTab;
            int iHashCode = (tab != null ? tab.hashCode() : 0) * 31;
            List<Tab> list = this.availableTabs;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(selectedTab=");
            sbU.append(this.selectedTab);
            sbU.append(", availableTabs=");
            return a.L(sbU, this.availableTabs, ")");
        }
    }

    public WidgetChannelSettingsPermissionsOverviewViewModel(long j, boolean z2) {
        super(WidgetChannelSettingsPermissionsOverviewViewModelKt.access$generateInitialViewState(z2));
        this.channelId = j;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final void selectTab(Tab tab) {
        m.checkNotNullParameter(tab, "tab");
        updateViewState(ViewState.copy$default(requireViewState(), tab, null, 2, null));
    }
}
