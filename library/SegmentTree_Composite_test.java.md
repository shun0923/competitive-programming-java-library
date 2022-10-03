---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/SegmentTree.java
    title: library/SegmentTree.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/point_set_range_composite
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_set_range_composite\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Mod;\nimport library.SegmentTree;\n\
    \npublic class SegmentTree_Composite_test extends Solver {\n\tpublic static void\
    \ main(final String[] args) { main(args, new SegmentTree_Composite_test()); }\n\
    \n\tpublic void solve() {\n\t\tlong mask = (1 << 31) - 1;\n\t\tMod md = Mod998.md;\n\
    \t\tint n = ni();\n\t\tint q = ni();\n\t\tlong f[] = new long[n];\n\t\tfor(int\
    \ i = 0; i < n; i ++) f[i] = nl() << 31 | nl();\n\t\tSegmentTree st = new SegmentTree(f,\n\
    \t\t\t1l << 31,\n\t\t\t(ele1, ele2) -> md.mul(ele1 >> 31, ele2 >> 31) << 31 |\
    \ md.mod((ele2 >> 31) * (ele1 & mask) + (ele2 & mask)));\n\t\tfor(int i = 0; i\
    \ < q; i ++) {\n\t\t\tif(ni() == 0) st.set(ni(), nl() << 31 | nl());\n\t\t\telse\
    \ {\n\t\t\t\tlong p = st.find(ni(), ni());\n\t\t\t\tprtln(md.mod((p >> 31) * nl()\
    \ + (p & mask)));\n\t\t\t}\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  - library/SegmentTree.java
  isVerificationFile: true
  path: library/SegmentTree_Composite_test.java
  requiredBy: []
  timestamp: '2022-09-20 18:45:11+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/SegmentTree_Composite_test.java
layout: document
redirect_from:
- /verify/library/SegmentTree_Composite_test.java
- /verify/library/SegmentTree_Composite_test.java.html
title: library/SegmentTree_Composite_test.java
---
