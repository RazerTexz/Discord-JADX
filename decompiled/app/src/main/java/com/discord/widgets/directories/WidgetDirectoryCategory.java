package com.discord.widgets.directories;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoryCategoryBinding;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.utilities.directories.DirectoryUtils2;
import com.discord.utilities.hubs.HubUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.directories.DirectoryChannelItem;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetDirectoryCategory.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoryCategory extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDirectoryCategory.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoryCategoryBinding;", 0)};
    private final ActivityResultLauncher<Intent> activityResult;
    private final WidgetDirectoryChannelAdapter adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DirectoryEntryCategory.values();
            int[] iArr = new int[11];
            $EnumSwitchMapping$0 = iArr;
            iArr[DirectoryEntryCategory.Home.ordinal()] = 1;
        }
    }

    /* compiled from: WidgetDirectoryCategory.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryCategory$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<WidgetDirectoriesViewModel.ViewState, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(WidgetDirectoriesViewModel.ViewState viewState) {
            return Boolean.valueOf(viewState != null);
        }
    }

    /* compiled from: WidgetDirectoryCategory.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryCategory$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryCategory widgetDirectoryCategory = WidgetDirectoryCategory.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetDirectoryCategory.access$configureUi(widgetDirectoryCategory, viewState);
        }
    }

    public WidgetDirectoryCategory() {
        super(R.layout.widget_directory_category);
        this.args = LazyJVM.lazy(new WidgetDirectoryCategory$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDirectoryCategory5.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetDirectoriesViewModel.class), new WidgetDirectoryCategory$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetDirectoryCategory6.INSTANCE));
        this.activityResult = HubUtils.getAddServerActivityResultHandler(this);
        this.adapter = new WidgetDirectoryChannelAdapter(new WidgetDirectoryCategory3(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetDirectoryCategory widgetDirectoryCategory, WidgetDirectoriesViewModel.ViewState viewState) {
        widgetDirectoryCategory.configureUi(viewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResult$p(WidgetDirectoryCategory widgetDirectoryCategory) {
        return widgetDirectoryCategory.activityResult;
    }

    private final void configureCategoryUi(WidgetDirectoriesViewModel.ViewState state) {
        List<DirectoryEntryData> listEmptyList = state.getDirectoryEntryData().get(Integer.valueOf(getArgs().getDirectoryCategory().getKey()));
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator<T> it = listEmptyList.iterator();
        while (it.hasNext()) {
            arrayList.add(new DirectoryChannelItem.DirectoryItem((DirectoryEntryData) it.next()));
        }
        List<DirectoryChannelItem> mutableList = _Collections.toMutableList((Collection) arrayList);
        maybeAddServerRow(mutableList, state);
        this.adapter.setDirectoryChannelItems(mutableList);
    }

    private final void configureHomeUi(WidgetDirectoriesViewModel.ViewState state) {
        List<DirectoryChannelItem.DirectoryItem> directoryItems;
        List<DirectoryChannelItem.DirectoryItem> directoryItems2;
        if (state.getChannel() != null) {
            if (ChannelUtils.x(state.getChannel())) {
                WidgetDirectoryChannelAdapter widgetDirectoryChannelAdapter = this.adapter;
                List<DirectoryChannelItem> mutableList = _Collections.toMutableList((Collection) toDirectoryItems(state.getAllDirectoryEntryData()));
                maybeAddServerRow(mutableList, state);
                widgetDirectoryChannelAdapter.setDirectoryChannelItems(mutableList);
                return;
            }
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            List<DirectoryEntryData> listSortByAdded = DirectoryUtils2.sortByAdded(state.getAllDirectoryEntryData());
            if (!(!listSortByAdded.isEmpty())) {
                listSortByAdded = null;
            }
            if (listSortByAdded != null && (directoryItems2 = toDirectoryItems(listSortByAdded)) != null) {
                arrayList.add(new DirectoryChannelItem.SectionHeader(R.string.search_newest));
                arrayList.addAll(directoryItems2);
                Iterator<T> it = directoryItems2.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(Long.valueOf(((DirectoryChannelItem.DirectoryItem) it.next()).getDirectoryEntryData().getEntry().getGuild().getId()));
                }
            }
            List<DirectoryEntryData> allDirectoryEntryData = state.getAllDirectoryEntryData();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : allDirectoryEntryData) {
                if (!linkedHashSet.contains(Long.valueOf(((DirectoryEntryData) obj).getEntry().getGuild().getId()))) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2.isEmpty() ^ true ? arrayList2 : null;
            if (arrayList3 != null && (directoryItems = toDirectoryItems(arrayList3)) != null) {
                arrayList.add(new DirectoryChannelItem.SectionHeader(R.string.all_servers));
                arrayList.addAll(directoryItems);
            }
            this.adapter.setDirectoryChannelItems(arrayList);
        }
    }

    private final void configureUi(WidgetDirectoriesViewModel.ViewState state) {
        if (getArgs().getDirectoryCategory().ordinal() != 0) {
            configureCategoryUi(state);
        } else {
            configureHomeUi(state);
        }
    }

    private final void maybeAddServerRow(List<DirectoryChannelItem> list, WidgetDirectoriesViewModel.ViewState viewState) {
        if (viewState.getHasAddGuildPermissions()) {
            list.add(DirectoryChannelItem.AddServer.INSTANCE);
        }
    }

    private final List<DirectoryChannelItem.DirectoryItem> toDirectoryItems(List<DirectoryEntryData> list) {
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new DirectoryChannelItem.DirectoryItem((DirectoryEntryData) it.next()));
        }
        return arrayList;
    }

    public final WidgetDirectoryChannelAdapter getAdapter() {
        return this.adapter;
    }

    public final WidgetDirectoryCategory2 getArgs() {
        return (WidgetDirectoryCategory2) this.args.getValue();
    }

    public final WidgetDirectoryCategoryBinding getBinding() {
        return (WidgetDirectoryCategoryBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetDirectoriesViewModel getViewModel() {
        return (WidgetDirectoriesViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f2364b;
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetDirectoriesViewModel.ViewState> observableY = getViewModel().observeViewState().y(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "viewModel\n        .obser…   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableY, this, null, 2, null), WidgetDirectoryCategory.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
