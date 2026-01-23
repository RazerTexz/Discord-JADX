package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.discord.utilities.display.DisplayUtils;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p076b.p077a.FlexInputCoordinator;
import p007b.p076b.p077a.p079d.MediaCursorAdapter;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: MediaFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MediaFragment extends Fragment {
    private static final int GRID_LAYOUT_SPAN_COUNT = 3;
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.MediaFragment$a */
    /* JADX INFO: compiled from: MediaFragment.kt */
    public static final class ViewOnClickListenerC11187a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ View f22073j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ MediaCursorAdapter f22074k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ MediaFragment f22075l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ FlexInputCoordinator f22076m;

        /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.MediaFragment$a$a */
        /* JADX INFO: compiled from: MediaFragment.kt */
        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                RecyclerView recyclerView = ViewOnClickListenerC11187a.this.f22075l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView);
                recyclerView.setLayoutManager(new GridLayoutManager(ViewOnClickListenerC11187a.this.f22073j.getContext(), 3));
                RecyclerView recyclerView2 = ViewOnClickListenerC11187a.this.f22075l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView2);
                recyclerView2.setAdapter(ViewOnClickListenerC11187a.this.f22074k);
                RecyclerView recyclerView3 = ViewOnClickListenerC11187a.this.f22075l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView3);
                recyclerView3.invalidateItemDecorations();
                return Unit.f27425a;
            }
        }

        public ViewOnClickListenerC11187a(View view, MediaCursorAdapter mediaCursorAdapter, MediaFragment mediaFragment, FlexInputCoordinator flexInputCoordinator) {
            this.f22073j = view;
            this.f22074k = mediaCursorAdapter;
            this.f22075l = mediaFragment;
            this.f22076m = flexInputCoordinator;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FlexInputCoordinator flexInputCoordinator = this.f22076m;
            if (flexInputCoordinator != null) {
                flexInputCoordinator.requestMediaPermissions(new a());
            }
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.fragment.MediaFragment$b */
    /* JADX INFO: compiled from: MediaFragment.kt */
    public static final class C11188b implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ View f22077a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ MediaCursorAdapter f22078b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ MediaFragment f22079c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ FlexInputCoordinator f22080d;

        public C11188b(View view, MediaCursorAdapter mediaCursorAdapter, MediaFragment mediaFragment, FlexInputCoordinator flexInputCoordinator) {
            this.f22077a = view;
            this.f22078b = mediaCursorAdapter;
            this.f22079c = mediaFragment;
            this.f22080d = flexInputCoordinator;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            if (MediaFragment.access$hasPermissions(this.f22079c, MediaFragment.REQUIRED_PERMISSION)) {
                MediaCursorAdapter mediaCursorAdapter = this.f22078b;
                Context context = this.f22077a.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                mediaCursorAdapter.m400b(contentResolver);
            }
            SwipeRefreshLayout swipeRefreshLayoutAccess$getSwipeRefreshLayout$p = MediaFragment.access$getSwipeRefreshLayout$p(this.f22079c);
            if (swipeRefreshLayoutAccess$getSwipeRefreshLayout$p != null) {
                swipeRefreshLayoutAccess$getSwipeRefreshLayout$p.setRefreshing(false);
            }
        }
    }

    public static final /* synthetic */ SwipeRefreshLayout access$getSwipeRefreshLayout$p(MediaFragment mediaFragment) {
        return mediaFragment.swipeRefreshLayout;
    }

    public static final /* synthetic */ boolean access$hasPermissions(MediaFragment mediaFragment, String... strArr) {
        return mediaFragment.hasPermissions(strArr);
    }

    public static final /* synthetic */ void access$setSwipeRefreshLayout$p(MediaFragment mediaFragment, SwipeRefreshLayout swipeRefreshLayout) {
        mediaFragment.swipeRefreshLayout = swipeRefreshLayout;
    }

    private final boolean hasPermissions(String... requiredPermissionList) {
        int length = requiredPermissionList.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            if (!(ContextCompat.checkSelfPermission(requireContext(), requiredPermissionList[i]) == 0)) {
                return false;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: getRecyclerView$flexinput_release, reason: from getter */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        return new EmptyListAdapter(C11170R.g.item_permission_storage, C11170R.f.permissions_req_btn, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        this.selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        Fragment parentFragment = getParentFragment();
        ActivityResultCaller parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof FlexInputCoordinator)) {
            parentFragment2 = null;
        }
        FlexInputCoordinator flexInputCoordinator = (FlexInputCoordinator) parentFragment2;
        if (flexInputCoordinator != null) {
            SelectionAggregator selectionAggregatorMo396b = flexInputCoordinator.mo396b();
            SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator);
            selectionAggregatorMo396b.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(C11170R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(C11170R.f.list);
        Intrinsics3.checkNotNullExpressionValue(viewInflate.getContext(), "context");
        int iWidth = (int) (DisplayUtils.getScreenSize(r6).width() / 3);
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator2 = this.selectionCoordinator;
        Intrinsics3.checkNotNull(selectionCoordinator2);
        MediaCursorAdapter mediaCursorAdapter = new MediaCursorAdapter(selectionCoordinator2, iWidth, iWidth);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(viewInflate.getContext(), 3));
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(mediaCursorAdapter);
            }
        } else {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(newPermissionsRequestAdapter(new ViewOnClickListenerC11187a(viewInflate, mediaCursorAdapter, this, flexInputCoordinator)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(C11170R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new C11188b(viewInflate, mediaCursorAdapter, this, flexInputCoordinator));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
        Intrinsics3.checkNotNull(selectionCoordinator);
        selectionCoordinator.itemSelectionListener.unregister();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(true);
        }
    }

    public final void setRecyclerView$flexinput_release(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
