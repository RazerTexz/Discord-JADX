package com.discord.widgets.botuikit.views.select;

import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.botuikit.SelectItem;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import d0.t.m0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: SelectComponentBottomSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class SelectComponentBottomSheetViewModel extends d0<ViewState> {
    private final ComponentContext componentContext;
    private final int componentIndex;
    private final String customId;
    private final boolean emojiAnimationsEnabled;
    private final PublishSubject<Event> eventSubject;
    private final boolean isMultiSelect;
    private final List<SelectItem> items;
    private final int max;
    private final int min;
    private final String placeholder;
    private final Set<SelectItem> selectedItems;
    private final List<SelectItem> selectedOptions;

    /* compiled from: SelectComponentBottomSheetViewModel.kt */
    public static abstract class Event {

        /* compiled from: SelectComponentBottomSheetViewModel.kt */
        public static final class CloseSheet extends Event {
            public static final CloseSheet INSTANCE = new CloseSheet();

            private CloseSheet() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SelectComponentBottomSheetViewModel.kt */
    public static final class ViewState {
        private final boolean emojiAnimationsEnabled;
        private final boolean isMultiSelect;
        private final boolean isValidSelection;
        private final List<SelectComponentBottomSheetItem> items;
        private final int maxSelections;
        private final int minSelections;
        private final boolean showSelectButton;
        private final String title;

        public ViewState(String str, List<SelectComponentBottomSheetItem> list, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5) {
            m.checkNotNullParameter(list, "items");
            this.title = str;
            this.items = list;
            this.showSelectButton = z2;
            this.isMultiSelect = z3;
            this.minSelections = i;
            this.maxSelections = i2;
            this.isValidSelection = z4;
            this.emojiAnimationsEnabled = z5;
        }

        public final boolean getEmojiAnimationsEnabled() {
            return this.emojiAnimationsEnabled;
        }

        public final List<SelectComponentBottomSheetItem> getItems() {
            return this.items;
        }

        public final int getMaxSelections() {
            return this.maxSelections;
        }

        public final int getMinSelections() {
            return this.minSelections;
        }

        public final boolean getShowSelectButton() {
            return this.showSelectButton;
        }

        public final String getTitle() {
            return this.title;
        }

        /* renamed from: isMultiSelect, reason: from getter */
        public final boolean getIsMultiSelect() {
            return this.isMultiSelect;
        }

        /* renamed from: isValidSelection, reason: from getter */
        public final boolean getIsValidSelection() {
            return this.isValidSelection;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentBottomSheetViewModel(ComponentContext componentContext, int i, String str, String str2, List<SelectItem> list, int i2, int i3, List<SelectItem> list2, boolean z2) {
        super(null, 1, null);
        m.checkNotNullParameter(componentContext, "componentContext");
        m.checkNotNullParameter(str, "customId");
        m.checkNotNullParameter(list, "items");
        m.checkNotNullParameter(list2, "selectedOptions");
        this.componentContext = componentContext;
        this.componentIndex = i;
        this.customId = str;
        this.placeholder = str2;
        this.items = list;
        this.min = i2;
        this.max = i3;
        this.selectedOptions = list2;
        this.emojiAnimationsEnabled = z2;
        this.isMultiSelect = i3 > 1;
        this.selectedItems = u.toMutableSet(list2);
        updateViewState();
        this.eventSubject = PublishSubject.k0();
    }

    private final boolean isValidSelection() {
        int i = this.min;
        int i2 = this.max;
        int size = this.selectedItems.size();
        return i <= size && i2 >= size;
    }

    private final void sendSelectInteraction(Set<SelectItem> selection) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getLocalActionComponentState().setSelectComponentSelection(this.componentContext.getMessageId(), this.componentIndex, u.toList(selection));
        StoreApplicationInteractions interactions = companion.getInteractions();
        long applicationId = this.componentContext.getApplicationId();
        Long guildId = this.componentContext.getGuildId();
        long channelId = this.componentContext.getChannelId();
        long messageId = this.componentContext.getMessageId();
        Long messageFlags = this.componentContext.getMessageFlags();
        int i = this.componentIndex;
        String str = this.customId;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(selection, 10));
        Iterator<T> it = selection.iterator();
        while (it.hasNext()) {
            arrayList.add(((SelectItem) it.next()).getValue());
        }
        interactions.sendComponentInteraction(applicationId, guildId, channelId, messageId, i, new RestAPIParams.ComponentInteractionData.SelectComponentInteractionData(null, str, u.toList(arrayList), 1, null), messageFlags);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.CloseSheet.INSTANCE);
    }

    public final ComponentContext getComponentContext() {
        return this.componentContext;
    }

    public final int getComponentIndex() {
        return this.componentIndex;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    public final List<SelectItem> getItems() {
        return this.items;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final Set<SelectItem> getSelectedItems() {
        return this.selectedItems;
    }

    public final List<SelectItem> getSelectedOptions() {
        return this.selectedOptions;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickSelect() {
        sendSelectInteraction(u.toSet(this.selectedItems));
    }

    @MainThread
    public final void selectItem(SelectItem selectItem, boolean selected) {
        m.checkNotNullParameter(selectItem, "selectItem");
        if (!this.isMultiSelect) {
            sendSelectInteraction(m0.setOf(selectItem));
            return;
        }
        if (selected) {
            this.selectedItems.add(selectItem);
        } else {
            this.selectedItems.remove(selectItem);
        }
        updateViewState();
    }

    public final void updateViewState() {
        String str = this.placeholder;
        List<SelectItem> list = this.items;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        for (SelectItem selectItem : list) {
            arrayList.add(new SelectComponentBottomSheetItem(selectItem, this.selectedItems.contains(selectItem)));
        }
        updateViewState(new ViewState(str, arrayList, this.isMultiSelect, this.isMultiSelect, this.min, this.max, isValidSelection(), this.emojiAnimationsEnabled));
    }
}
