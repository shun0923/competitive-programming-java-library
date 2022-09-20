---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/TemplatedDynamicSegmentTree_Small_test.java
    title: library/TemplatedDynamicSegmentTree_Small_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplatedDynamicSegmentTree_test.java
    title: library/TemplatedDynamicSegmentTree_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':question:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplatedDynamicSegmentTree.java\n"
  code: "package library;\n\nimport java.util.function.*;\nimport library.SimpleUtil;\n\
    \nclass TemplatedDynamicSegmentTree<T> {\n\tclass NodeST {\n\t\tT val;\n\t\tNodeST\
    \ l = null;\n\t\tNodeST r = null;\n\t\tNodeST() { val = eSupplier.get(); }\n\t\
    \tNodeST(T val) { this.val = val; }\n\t}\n\n\tlong n;\n\tSupplier<T> eSupplier;\n\
    \tT e;\n\tBinaryOperator<T> f;\n\n\tNodeST root;\n\n\t// O(1)\n\tTemplatedDynamicSegmentTree(long\
    \ len, Supplier<T> eSupplier, BinaryOperator<T> f) {\n\t\tSimpleUtil.nonNegativeCheck(len);\n\
    \t\tthis.n = len; this.eSupplier = eSupplier; this.e = eSupplier.get(); this.f\
    \ = f;\n\t\troot = new NodeST();\n\t}\n\n\t// O(logN)\n\tvoid set(long i, T val)\
    \ { SimpleUtil.rangeCheck(i, n); update(i, val, false); }\n\tvoid update(long\
    \ i, T val) { SimpleUtil.rangeCheck(i, n); update(i, val, true); }\n\tvoid update(long\
    \ i, T val, boolean update) { update(root, 0, n, i, val, update); }\n\tNodeST\
    \ update(NodeST t, long l, long r, long i, T val, boolean update) {\n\t\tif(t\
    \ == null) t = new NodeST();\n\t\tif(r - l == 1) { t.val = update ? f.apply(t.val,\
    \ val) : val; return t; }\n\t\tlong mid = (l + r) >> 1;\n\t\tif(i < mid) t.l =\
    \ update(t.l, l, mid, i, val, update);\n\t\telse t.r = update(t.r, mid, r, i,\
    \ val, update);\n\t\tt.val = eSupplier.get();\n\t\tif(t.l != null) t.val = f.apply(t.val,\
    \ t.l.val);\n\t\tif(t.r != null) t.val = f.apply(t.val, t.r.val);\n\t\treturn\
    \ t;\n\t}\n\n\t// O(logN)\n\tT get(long i) { SimpleUtil.rangeCheck(i, n); return\
    \ get(root, 0, n, i); }\n\tT get(NodeST t, long l, long r, long i) {\n\t\tif(t\
    \ == null) return e;\n\t\tif(r - l == 1) return t.val;\n\t\tlong mid = (l + r)\
    \ >> 1;\n\t\treturn i < mid ? get(t.l, l, mid, i) : get(t.r, mid, r, i);\n\t}\n\
    \tT find(long l0, long r0) {\n\t\tSimpleUtil.inclusiveRangeCheck(l0, n);\n\t\t\
    SimpleUtil.inclusiveRangeCheck(r0, n);\n\t\tSimpleUtil.assertion(l0 <= r0, \"\
    l is larger than r.\");\n\t\treturn find(root, 0, n, l0, r0);\n\t}\n\tT find(NodeST\
    \ t, long l, long r, long l0, long r0) {\n\t\tif(l == r || t == null || r0 <=\
    \ l || r <= l0) return e;\n\t\tif(l0 <= l && r <= r0) return t.val;\n\t\tlong\
    \ mid = (l + r) >> 1;\n\t\treturn f.apply(find(t.l, l, mid, l0, r0), find(t.r,\
    \ mid, r, l0, r0));\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/TemplatedDynamicSegmentTree.java
  requiredBy: []
  timestamp: '2022-09-20 17:46:28+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - library/TemplatedDynamicSegmentTree_Small_test.java
  - library/TemplatedDynamicSegmentTree_test.java
documentation_of: library/TemplatedDynamicSegmentTree.java
layout: document
redirect_from:
- /library/library/TemplatedDynamicSegmentTree.java
- /library/library/TemplatedDynamicSegmentTree.java.html
title: library/TemplatedDynamicSegmentTree.java
---
