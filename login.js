const USERS_KEY   = 'tc_users';
    const SESSION_KEY = 'tc_session';
    const getUsers    = () => JSON.parse(localStorage.getItem(USERS_KEY)   || '[]');
    const saveUsers   = u  => localStorage.setItem(USERS_KEY,   JSON.stringify(u));
    const saveSession = u  => localStorage.setItem(SESSION_KEY, JSON.stringify(u));

    function switchPanel(p) {
      document.getElementById('panelLogin').classList.toggle('active',    p === 'login');
      document.getElementById('panelRegister').classList.toggle('active', p === 'register');
      clearErrors();
    }

    window.addEventListener('DOMContentLoaded', () => {
      const panel = sessionStorage.getItem('tc_open_panel') || 'login';
      sessionStorage.removeItem('tc_open_panel');
      switchPanel(panel);
    });

    function clearErrors() {
      ['loginError','loginEmailErr','loginPassErr',
       'registerError','registerSuccess',
       'regLastErr','regFirstErr','regEmailErr','regPhoneErr','regPassErr','regPass2Err'
      ].forEach(id => {
        const el = document.getElementById(id);
        if (el) { el.textContent = ''; el.style.display = 'none'; }
      });
    }

    function setErr(id, msg) {
      const el = document.getElementById(id);
      if (!el) return;
      el.textContent = msg; el.style.display = 'block';
    }

    function togglePw(id, btn) {
      const inp = document.getElementById(id);
      const hide = inp.type === 'password';
      inp.type = hide ? 'text' : 'password';
      btn.textContent = hide ? 'Ẩn' : 'Hiện';
    }

    function checkStrength(val) {
      let s = 0;
      if (val.length >= 8)           s++;
      if (/[A-Z]/.test(val))         s++;
      if (/[0-9]/.test(val))         s++;
      if (/[^A-Za-z0-9]/.test(val))  s++;
      const colors = ['#e84545','#f0a040','#f0c040','#2ecc71'];
      [1,2,3,4].forEach(i => {
        document.getElementById('sb'+i).style.background =
          i <= s ? colors[s-1] : 'rgba(255,255,255,0.1)';
      });
    }

    function redirectHome(msg, type = 'success') {
      sessionStorage.setItem('tc_toast',      msg);
      sessionStorage.setItem('tc_toast_type', type);
      window.location.href = 'index.html';
    }

    function doLogin() {
      clearErrors();
      const email = document.getElementById('loginEmail').value.trim();
      const pass  = document.getElementById('loginPass').value;
      let ok = true;
      if (!email)                             { setErr('loginEmailErr','Vui lòng nhập email'); ok=false; }
      else if (!/^\S+@\S+\.\S+$/.test(email)){ setErr('loginEmailErr','Email không hợp lệ'); ok=false; }
      if (!pass)                              { setErr('loginPassErr','Vui lòng nhập mật khẩu'); ok=false; }
      if (!ok) return;
      const user = getUsers().find(u => u.email === email && u.password === pass);
      if (!user) { setErr('loginError','Email hoặc mật khẩu không đúng. Vui lòng thử lại.'); return; }
      saveSession(user);
      redirectHome(`Chào mừng trở lại, ${user.first}!`);
    }

    function doRegister() {
      clearErrors();
      const last  = document.getElementById('regLast').value.trim();
      const first = document.getElementById('regFirst').value.trim();
      const email = document.getElementById('regEmail').value.trim();
      const phone = document.getElementById('regPhone').value.trim();
      const pass  = document.getElementById('regPass').value;
      const pass2 = document.getElementById('regPass2').value;
      let ok = true;
      if (!last)  { setErr('regLastErr','Vui lòng nhập họ'); ok=false; }
      if (!first) { setErr('regFirstErr','Vui lòng nhập tên'); ok=false; }
      if (!email) { setErr('regEmailErr','Vui lòng nhập email'); ok=false; }
      else if (!/^\S+@\S+\.\S+$/.test(email)) { setErr('regEmailErr','Email không hợp lệ'); ok=false; }
      if (!phone) { setErr('regPhoneErr','Vui lòng nhập số điện thoại'); ok=false; }
      else if (!/^(0|\+84)[0-9]{8,9}$/.test(phone)) { setErr('regPhoneErr','Số điện thoại không hợp lệ'); ok=false; }
      if (!pass)          { setErr('regPassErr','Vui lòng nhập mật khẩu'); ok=false; }
      else if (pass.length<8) { setErr('regPassErr','Mật khẩu tối thiểu 8 ký tự'); ok=false; }
      if (pass !== pass2) { setErr('regPass2Err','Mật khẩu xác nhận không khớp'); ok=false; }
      if (!ok) return;
      const users = getUsers();
      if (users.find(u => u.email === email)) {
        setErr('registerError','Email này đã được đăng ký. Vui lòng đăng nhập.'); return;
      }
      const newUser = { last, first, email, phone, password: pass };
      users.push({
  username: email,
  password: pass,
  createdAt: new Date().toISOString()
}); saveUsers(users); saveSession(newUser);
      redirectHome(`Tạo tài khoản thành công! Chào mừng, ${first}!`);
    }

    document.addEventListener('keydown', e => {
      if (e.key === 'Escape') window.location.href = 'index.html';
    });
