function handleStatusUpdate(orderId, currentStatus, receiveMethod) {
    const statusMessages = [
        "Xác nhận đơn hàng, tiến hành chuẩn bị đơn hàng?",
        "Hoàn tất chuẩn bị, sẵn sàng bàn giao đơn hàng?",
        "Hoàn tất bàn giao đơn hàng?"
    ];

    if (currentStatus >= statusMessages.length) {
        alert("Trạng thái hiện tại đã đạt tối đa!");
        return;
    }

    let nextStatus;
    if (currentStatus === 2 && receiveMethod === 0) {
        nextStatus = 4; // Nhận tại cửa hàng
    } else if (currentStatus === 2 && receiveMethod === 1) {
        nextStatus = 3; // Giao hàng tận nơi
    } else {
        nextStatus = currentStatus + 1;
    }

    const confirmation = confirm(statusMessages[currentStatus]);
    if (!confirmation) return;

    const statusButton = document.querySelector(`#status-btn-${orderId}`);
    statusButton.textContent = "Đang xử lí....";
    statusButton.className = "status-button status-processing";
    statusButton.disabled = true;

    fetch("/j2ee/admin/orderServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams({
            action: "updateStatus",
            id: orderId,
            currentStatus: currentStatus,
            receiveMethod: receiveMethod
        })
    })
    .then(response => response.text()) // Chuyển sang text để kiểm tra nội dung phản hồi
    .then(text => {
        try {
            const data = JSON.parse(text); // Thử parse JSON từ phản hồi
            if (data.success) {
                alert(data.message);
                location.reload();
            } else {
                alert(data.message || "Cập nhật trạng thái thất bại!");
                statusButton.textContent = statusMessages[currentStatus];
                statusButton.disabled = false;
            }
        } catch (error) {
            console.error("Phản hồi không phải JSON hợp lệ:", text);
            alert("Đã xảy ra lỗi không mong muốn!");
            statusButton.textContent = statusMessages[currentStatus];
            statusButton.disabled = false;
        }
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Đã xảy ra lỗi!");
        statusButton.textContent = statusMessages[currentStatus];
        statusButton.disabled = false;
    });
}

function confirmCancel(orderId) {
    const confirmation = confirm("Xác nhận huỷ đơn hàng?");
    if (!confirmation) return;

    const cancelButton = document.querySelector(`#cancel-btn-${orderId}`);
    cancelButton.textContent = "Đang xử lí....";
    cancelButton.className = "cancel-button disabled";
    cancelButton.disabled = true;

    fetch("/j2ee/admin/orderServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams({
            action: "cancelOrder",
            id: orderId
        })
    })
    .then(response => response.text()) // Chuyển sang text để kiểm tra nội dung phản hồi
    .then(text => {
        try {
            const data = JSON.parse(text); // Thử parse JSON từ phản hồi
            if (data.success) {
                alert(data.message);
                location.reload();
            } else {
                alert(data.message || "Hủy đơn hàng thất bại!");
                cancelButton.textContent = "Huỷ đơn hàng";
                cancelButton.disabled = false;
            }
        } catch (error) {
            console.error("Phản hồi không phải JSON hợp lệ:", text);
            alert("Đã xảy ra lỗi không mong muốn!");
            cancelButton.textContent = "Huỷ đơn hàng";
            cancelButton.disabled = false;
        }
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Đã xảy ra lỗi!");
        cancelButton.textContent = "Huỷ đơn hàng";
        cancelButton.disabled = false;
    });
}
