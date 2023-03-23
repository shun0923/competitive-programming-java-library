---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Permutation_test.java
    title: library/Permutation_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nclass\
    \ Permutation implements Iterator<int[]>, Iterable<int[]> { // N=next.length\n\
    \tprivate int next[];\n\n\t// O(N)\n\tpublic Permutation(int n) {\n\t\tSimpleUtil.nonNegativeCheck(n);\n\
    \t\tnext = new int[n];\n\t\tfor(int i = 0; i < n; i ++) next[i] = i;\n\t}\n\t\
    public Permutation(int[] a) {\n\t\tnext = a.clone();\n\t}\n\n\t@Override\n\tpublic\
    \ final boolean hasNext() { return next != null; } // O(1)\n\n\t@Override\n\t\
    public final int[] next() { // O(1)\n\t\tint[] r = next.clone();\n\t\tnext = nextPermutation(next);\n\
    \t\treturn r;\n\t}\n\n\t@Override\n\tpublic final Iterator<int[]> iterator() {\
    \ return this; } // O(1)\n\n\tpublic final int[] nextPermutation(int[] a) { //\
    \ O(N)\n\t\tif(a == null || a.length < 2) return null;\n\t\tint p = 0;\n\t\tfor(int\
    \ i = a.length - 2; i >= 0; i --) {\n\t\t\tif(a[i] >= a[i + 1]) continue;\n\t\t\
    \tp = i;\n\t\t\tbreak;\n\t\t}\n\t\tint q = 0;\n\t\tfor(int i = a.length - 1; i\
    \ > p; i --) {\n\t\t\tif(a[i] <= a[p]) continue;\n\t\t\tq = i;\n\t\t\tbreak;\n\
    \t\t}\n\t\tif(p == 0 && q == 0) return null;\n\t\tswap(a, p, q);\n\t\tint l =\
    \ p;\n\t\tint r = a.length;\n\t\twhile(++ l < -- r) swap(a, l, r);\n\t\treturn\
    \ a;\n\t}\n\n\tprivate static final void swap(int[] a, int l, int r) {\n\t\tint\
    \ tmp = a[l];\n\t\ta[l] = a[r];\n\t\ta[r] = tmp;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/Permutation.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Permutation_test.java
documentation_of: library/Permutation.java
layout: document
redirect_from:
- /library/library/Permutation.java
- /library/library/Permutation.java.html
title: library/Permutation.java
---
